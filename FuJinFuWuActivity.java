package com.example.lk.petexperts;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class FuJinFuWuActivity extends AppCompatActivity {
    public LocationClient mLocationClient;
    private MapView mapView;
    private BaiduMap baiduMap;
    private boolean isFirstLocate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //首先创建了一个LocationClient的实例，LocationClient的构造函数接受一个Context参数，
        // 这里调用getApplicationContext()方法来获取一个全局的Context参数并传入。
        mLocationClient = new LocationClient(getApplicationContext());
        //然后调用LocationClient的registerLocationListener方法来注册一个 定位监听器，
        // 当获取到位置信息的时候，就会回掉这个定位监视器
        mLocationClient.registerLocationListener(new MyLocationListener());

        SDKInitializer.initialize(getApplicationContext());//首先我们调用SDKInitializer的initialize（）方法来进行初始化操作

        setContentView(R.layout.activity_fu_jin_fu_wu);

        mapView = (MapView) findViewById(R.id.bmapView);
        baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);


        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(FuJinFuWuActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(FuJinFuWuActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(FuJinFuWuActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(FuJinFuWuActivity.this, permissions, 1);
        } else {
            requestLocation();
        }
    }

    private void navigateTo(BDLocation location) {
        if (isFirstLocate) {
            //先是将BDLocation对象中的地理位置信息取出并封装到LatLng对象中，
            // 然后调用MapStatusUpdateFactory的newLatLng方法将LatLng对象传入，
            // 接着将返回的 MapStatusUpdate对象作为参数传入到BaiduMap的animateMapStatus方法当中
            LatLng ll = new LatLng(location.getLatitude(), location.getLongitude());
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
            baiduMap.animateMapStatus(update);
            update = MapStatusUpdateFactory.zoomTo(16f);
            baiduMap.animateMapStatus(update);
            isFirstLocate = false;
            //isFirstLocate变量的作用是为了防止多次调用animateMapStatus（）方法，
            // 因为将地图移动到我们当前的位置只需要在程序第一次定位的时候调用一次就可以了
        }
        //我们添加了MyLocationData的构建逻辑，将Location中包含的经度和纬度分别封装到了MyLocationData.Builder当中，
        // 最后把MyLocationData设置到了BaiduMap的setMyLocationData方法中，
        // 这段逻辑必须写在isFirstLocate这个if条件语句的外面，因为让地图移动到我们当前的位置只需要在第一次定位的时候执行，
        // 但是设备在地图上显示却应该是随着设备的移动而实时改变的，
        // 另外，根据百度地图的限制，如果我们想要使用这一功能，一定要事先调用BaiduMap的setMyLocationEnabled方法将此功能开启，否则设备的位置将无法在地图上显示。
        // 而在程序退出的时候，也要记得将此功能给关闭掉
        MyLocationData.Builder locationBuilder = new MyLocationData.Builder();
        locationBuilder.latitude(location.getLatitude());
        locationBuilder.longitude(location.getLongitude());
        MyLocationData locationData = locationBuilder.build();
        baiduMap.setMyLocationData(locationData);
    }

    private void requestLocation() {
        initLocation();
        mLocationClient.start();//调用start（）方法开始定位，定位的结果会回掉到我们前面注册的监听器中

    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();//创建一个LocationClientOption对象
        option.setScanSpan(5000);//然后调用它的setScanSpan方法来设置更新的间隔。这里表示每5秒钟会更新一下当前的位置
        // option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);//定位模式指定城传感器模式
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();

        mapView.onDestroy();
        baiduMap.setMyLocationEnabled(false);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    private class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
//            StringBuilder currentPosition = new StringBuilder();
//            currentPosition.append("纬度：").append(location.getLatitude()).append("\n");
//            currentPosition.append("经线:").append(location.getLongitude()).append("\n");
//
//            currentPosition.append("国家：").append(location.getCountry()).append("\n");
//            currentPosition.append("省：").append(location.getProvince()).append("\n");
//            currentPosition.append("市：").append(location.getCity()).append("\n");
//            currentPosition.append("区：").append(location.getDistrict()).append("\n");
//            currentPosition.append("街道：").append(location.getStreet()).append("\n");
//
//            currentPosition.append("定位方式:");
//            if (location.getLocType() == BDLocation.TypeGpsLocation) {
//                currentPosition.append("GPS");
//            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
//                currentPosition.append("网络");
//            }
//            positionText.setText(currentPosition);

            if (location.getLocType() == BDLocation.TypeGpsLocation || location.getLocType() == BDLocation.TypeNetWorkLocation) {
                navigateTo(location);//将BDLocation对象传给navigateTo方法，这样就能够让地图移动到设备所在的位置了
            }
        }
    }
}
