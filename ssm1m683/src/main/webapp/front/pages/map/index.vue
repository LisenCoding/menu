<template>
	<view class="content">
		<input type="text" style="width: 100%;text-align: center;background: #eee;color: #000;" v-model="key" @input="search" placeholder="地址搜索" />
		<scroll-view scroll-y="true" class="option" v-show="IsOption">
			<view class='column_item' v-for='(item,index) in data' :key='index' @click="tapOption(item)">{{item.title}}
			</view>
		</scroll-view>
		<map v-show="!IsOption" id="map" style="width: 100%; height: 450px;z-index: -1;" :latitude="latitude" :longitude="longitude" :markers="markers"
			 show-location></map>
		<button type="primary" class="btn" @click="openMapApp">导航</button>
	</view>
</template>

<script>
	var QQMapWX = require('../../common/qqmap/qqmap-wx-jssdk.min.js');
	var qqmapsdk;
	var self;
	export default {
		data() {
			return {
				keyword: '',
				data: [],
				latitude: 23.099994,
				longitude: 113.324520,
				IsOption: false,
				key: '',
				markers: [{
					id: 1,
					latitude: 23.099994,
					longitude: 113.324520,
					width:18,
					height:22,
					name: 'T.I.T 创意园',
					iconPath: '../../static/location.png',
				}],
			}
		},
		onLoad() {
			self = this
			let that = this
			// 实例化API核心类
			qqmapsdk = new QQMapWX({
				key: 'Y77BZ-RDDYJ-TKLFM-KPSXB-3AXPJ-QHFD4'
			});
			uni.getLocation({
				altitude: true,
				success(res) {
					// console.log(res)
					self.longitude = res.longitude
					self.latitude = res.latitude
				}
			})
			self.mapCtr = uni.createMapContext('map')
		},
		methods: {
			search() {
				// #ifdef H5
				var location1 = 'nearby(' + self.latitude + "," + self.longitude + ',1000,1)'
				const KEY = "Y77BZ-RDDYJ-TKLFM-KPSXB-3AXPJ-QHFD4";
				  let url = "https://apis.map.qq.com/ws/place/v1/search"
				  let keyword = self.key
				  self.$jsonp(url, {
				      key: KEY,
				      boundary: location1,
				      keyword: keyword,
				      output: "jsonp"
				  }).then(res => {
				      self.data = res.data
				      if (self.key && res.data.length) {
				      	self.IsOption = true
				      } else {
				      	self.IsOption = false
				      }
				  }).catch(err => {
				     console.log(err)
				  })
				return false
				// #endif
				var location = self.latitude + "," + self.longitude 
				self.mapSearch(self.key, location).then(res1 => {
					// console.log(111, res)
					self.data = res1.data
					if (self.key && res1.data.length) {
						self.IsOption = true
					} else {
						self.IsOption = false
					}
				
				}, error => {
					// console.log(error, "aaaaaaaaaaa");
				})

				// return false
				
			},
			tapOption: function(item) {
				self.latitude = item.location.lat;
				self.longitude = item.location.lng;
				self.markers[0].latitude = item.location.lat;
				self.markers[0].longitude = item.location.lng;
				self.searchKey = item.title
				self.IsOption = false
				self.data = []
				var obj = {}
				obj.latitude = item.location.lat;
				obj.longitude = item.location.lng;
				// console.log(item,"danji",obj)
				self.toLocation(obj)
			},
			toLocation: function(obj) {
				self.mapCtr.moveToLocation(obj)
				self.mapCtr.translateMarker({
					markerId: 1,
					autoRotate: true,
					duration: 100,
					destination: {
						latitude: obj.latitude,
						longitude: obj.longitude,
					},
					animationEnd() {
						// console.log('animation end')
					}
				})
			},
			openMapApp() {
				let latitude = self.latitude;
				let longitude = self.longitude;

				// console.log(latitude)
				uni.openLocation({
					latitude: latitude,
					longitude: longitude,
					success: function(res) {
						// console.log(res);
					}
				});

			},
			mapSearch(keyword, location) {
				// console.log(keyword, location, "keyword,location")
				let promise = new Promise(function(resolve, reject) {
					// 调用接口
					// console.log(121)
					qqmapsdk.search({
						keyword: keyword, //搜索关键词
						location: location, //设置周边搜索中心点
						success: function(res) {
							resolve(res)
						},
						fail: function(res) {
							// console.log(222)
							reject(res)
						}
					});
				})
				return promise
			},
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}

	.option {
		max-height: 300rpx;
		width: 100%;

		line-height: 60rpx;
		position: fixed;
		/* #ifdef H5 */
		top: 188rpx;
		/* #endif */
		/* #ifdef MP-WEIXIN */
		top: 42rpx;
		/* #endif */
		/* #ifdef APP-VUE */
		top: 98rpx;
		/* #endif */
		z-index: 9999;
	}

	.column_item {
		padding: 0 40rpx;
		height: 60rpx;
		width: 524rpx;
		overflow: hidden;
		margin: 0rpx auto;
		background-color: #fff;
		text-overflow: ellipsis;
		white-space: nowrap;
	}

	.column_item:active {
		background-color: #8F8F94;
	}
	.btn{
		position: fixed;
		bottom:  var(--window-bottom);
		left: 0;
		width: 100%;
		height: 88rpx;
		border-radius: 0;
	}
</style>
