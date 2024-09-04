<template>
	<view class="content">
		<view @tap="onPageTap('../user-info/user-info')" class="header" v-bind:class="{'status':isH5Plus}" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(80, 96, 93, 1)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"260rpx"}'>

			<view :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"20rpx 0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(0, 0, 0, 0)","borderRadius":"16rpx","borderWidth":"0","width":"calc(100% - 112rpx)","borderStyle":"solid","height":"160rpx"}'v-if="tableName=='yonghu'" class="userinfo">
				<view class="info">
					<view class="username" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(255,255,255,0)","margin":"6rpx 0","backgroundColor":"rgba(0,0,0,0)","borderColor":"rgba(255,255,255,.3)","color":"#fff","textAlign":"left","borderRadius":"8rpx","borderWidth":"0","width":"auto","lineHeight":"36rpx","fontSize":"28rpx","borderStyle":"solid"}'>{{user.yonghuzhanghao}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
				</view>
			</view>
			<view class="setting">
				<!-- <image src="/static/center/setting.png"></image> -->
				<view :style='{"padding":"0","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0 0 0 80rpx","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(0,0,0,0)","borderRadius":"0","color":"#fff","borderWidth":"0","width":"32rpx","lineHeight":"32rpx","fontSize":"32rpx","borderStyle":"solid"}' class="cuIcon-settings"></view>
			</view>
		</view>
		<view class="list" :style='{"padding":"0 24rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"24rpx 0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'>

			<block v-for="item in menuList" v-bind:key="item.roleName">
				<block v-if="role==item.roleName" v-bind:key="index" v-for=" (menu,index) in item.backMenu">
					<block v-bind:key="sort" v-for=" (child,sort) in menu.child">
						<view :style='{"padding":"0","boxShadow":"0px 6rpx 12rpx rgba(0, 0, 0, 0.16)","margin":"20rpx 10rpx","backgroundColor":"#fff","borderColor":"#ccc","borderRadius":"0","borderWidth":"0","width":"46%","borderStyle":"solid","height":"100rpx"}' v-if="child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap('../'+child.tableName+'/list?userid='+user.id)" class="li" hover-class="hover">
							<view v-if="true" :style='{"padding":"0","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0 10rpx","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(0, 186, 189, 1)","isShow":true,"borderRadius":"0","borderWidth":"0","width":"50rpx","lineHeight":"50rpx","fontSize":"64rpx","borderStyle":"solid"}' :class="child.appFrontIcon"></view>
							<view :style='{"padding":"0 20rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(0,0,0,0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"calc(100% - 100rpx)","lineHeight":"80rpx","fontSize":"28rpx","borderStyle":"solid"}' class="text">{{child.menu}}</view>
							<!-- <image :style='{"padding":"0","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"#fff","color":"rgba(161, 161, 161, 1)","isShow":true,"borderRadius":"0","borderWidth":"0","width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","borderStyle":"solid"}' class="to" src="/static/center/to.png"></image> -->
							<view v-if="true" class="cuIcon-right" :style='{"padding":"0","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"#fff","color":"rgba(161, 161, 161, 1)","isShow":true,"borderRadius":"0","borderWidth":"0","width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","borderStyle":"solid"}'></view>
						</view>
					</block>
				</block>
			</block>


		</view>
	</view>
</template>
<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				isH5Plus: true,
				user: {},
				tableName:'',
				role: '',
				menuList: [],
        iconArr: [
          'cuIcon-same',
          'cuIcon-deliver',
          'cuIcon-evaluate',
          'cuIcon-shop',
          'cuIcon-ticket',
          'cuIcon-cascades',
          'cuIcon-discover',
          'cuIcon-question',
          'cuIcon-pic',
          'cuIcon-filter',
          'cuIcon-footprint',
          'cuIcon-pulldown',
          'cuIcon-pullup',
          'cuIcon-moreandroid',
          'cuIcon-refund',
          'cuIcon-qrcode',
          'cuIcon-remind',
          'cuIcon-profile',
          'cuIcon-home',
          'cuIcon-message',
          'cuIcon-link',
          'cuIcon-lock',
          'cuIcon-unlock',
          'cuIcon-vip',
          'cuIcon-weibo',
          'cuIcon-activity',
          'cuIcon-friendadd',
          'cuIcon-friendfamous',
          'cuIcon-friend',
          'cuIcon-goods',
          'cuIcon-selection'
        ],
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad(){
			this.role = uni.getStorageSync("role");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
		},
		async onShow(){
            uni.removeStorageSync("useridTag");
			this.role = uni.getStorageSync("role");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
		},
		methods: {
			onPageTap(url) {
                uni.setStorageSync("useridTag",1);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			}
		}
	}
</script>

<style lang="scss">
	page {
		background-color: #fff;
	}

	.content:after {
		position: fixed;
		top: 0;
		right: 0;
		left: 0;
		bottom: 0;
		content: '';
		background-attachment: fixed;
		background-size: cover;
		background-position: center;
	}

	.header {
		&.status {
			padding-top: var(--status-bar-height);
		}

		background-color:#ff6364;
		width:100%;
		height:30vw;
		padding:0 4%;
		display:flex;
		align-items:center;

		.userinfo {
			width: 100%;
			display: flex;
			align-items: center;

			.face {
				flex-shrink: 0;
				width: 15vw;
				height: 15vw;
				overflow: hidden;

				image {
					width: 100%;
					height: 100%;
					// border-radius: 100%
				}
			}

			.info {
				// display: flex;
				flex-flow: wrap;
				// padding-left: 30upx;

				.username {
					width: 100%;
					color: #fff;
					font-size: 40upx;
					// margin-bottom: 10upx;
					// margin-left: 10upx;
					margin: 8upx 0;
				}

				.integral {
					display: flex;
					align-items: center;
					padding: 0 8upx;
					// height: 40upx;
					color: #fff;
					background-color: rgba(0, 0, 0, 0.1);
					border-radius: 20upx;
					font-size: 24upx;
					// margin-bottom: 10upx;
					margin: 8upx 0;
				}
			}
		}

		.setting {
			flex-shrink: 0;
			// width: 6vw;
			// height: 6vw;

			image {
				width: 100%;
				height: 100%
			}
		}
	}

	.hover {
		background-color: #eee
	}

	.orders {
		background-color: #ff6364;
		width: 100%;
		height: 11vw;
		padding: 0 4%;
		margin-bottom: calc(11vw + 40upx);
		display: flex;
		align-items: flex-start;
		border-radius: 0 0 100% 100%;
		margin-top: -1upx;

		.box {
			width: 100%;
			padding: 0 1%;
			height: 22vw;
			background-color: #fefefe;
			border-radius: 24upx;
			box-shadow: 0 0 20upx rgba(0, 0, 0, 0.15);
			margin-bottom: 40upx;
			display: flex;
			align-items: center;
			justify-content: center;

			.label {
				display: flex;
				align-items: center;
				justify-content: center;
				flex-flow: wrap;
				width: 100%;
				height: 16vw;
				color: #666666;
				font-size: 26upx;

				.icon {
					position: relative;
					width: 7vw;
					height: 7vw;
					margin: 0 1vw;

					.badge {
						position: absolute;
						width: 4vw;
						height: 4vw;
						background-color: #ec6d2c;
						top: -1vw;
						right: -1vw;
						border-radius: 100%;
						font-size: 20upx;
						color: #fff;
						display: flex;
						align-items: center;
						justify-content: center;
						z-index: 10;
					}

					image {
						width: 7vw;
						height: 7vw;
						z-index: 9;
					}
				}
			}
		}
	}

	.list {
		width: 100%;
		border-bottom: solid 26upx #f1f1f1;
		display: flex;
		flex-wrap: wrap;

		.li {
			width: 100%;
			height: 100upx;
			padding: 0 4%;
			border-bottom: solid 1upx #e7e7e7;
			display: flex;
			align-items: center;
			background: #FFFFFF;
			font-size: 33upx;
			flex-wrap: wrap;

			&.noborder {
				border-bottom: 0
			}

			.icon {
				flex-shrink: 0;
				width: 50upx;
				height: 50upx;

				image {
					width: 50upx;
					height: 50upx
				}
			}

			.text {
				padding-left: 20upx;
				width: 100%;
				color: #666
			}

			.to {
				flex-shrink: 0;
				width: 40upx;
				height: 40upx
			}
		}
	}
</style>
