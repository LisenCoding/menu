<template>
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback" :bottom="100">
		<view class="container">
            <view class="detail-content">



				<view class="detail-list-item" :style='{"padding":"10rpx","boxShadow":"0 0 4rpx rgba(0,0,0,.3)","margin":"0","borderColor":"#fff","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 0 0 20rpx","boxShadow":"0 0 0px rgba(0,0,0,0)","margin":"0 ","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(0,0,0,0)","color":"#333","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","borderStyle":"solid"}'>用户名：</view>
					<view class="text" :style='{"padding":"0 ","boxShadow":"0 0 0px rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(0,0,0,0)","color":"#333","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"calc(100% - 160rpx)","lineHeight":"auto","fontSize":"28rpx","borderStyle":"solid"}'>{{detail.username}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"10rpx","boxShadow":"0 0 4rpx rgba(0,0,0,.3)","margin":"0","borderColor":"#fff","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 0 0 20rpx","boxShadow":"0 0 0px rgba(0,0,0,0)","margin":"0 ","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(0,0,0,0)","color":"#333","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","borderStyle":"solid"}'>密码：</view>
					<view class="text" :style='{"padding":"0 ","boxShadow":"0 0 0px rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(0,0,0,0)","color":"#333","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"calc(100% - 160rpx)","lineHeight":"auto","fontSize":"28rpx","borderStyle":"solid"}'>{{detail.password}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"10rpx","boxShadow":"0 0 4rpx rgba(0,0,0,.3)","margin":"0","borderColor":"#fff","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 0 0 20rpx","boxShadow":"0 0 0px rgba(0,0,0,0)","margin":"0 ","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(0,0,0,0)","color":"#333","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","borderStyle":"solid"}'>角色：</view>
					<view class="text" :style='{"padding":"0 ","boxShadow":"0 0 0px rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(0,0,0,0)","color":"#333","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"calc(100% - 160rpx)","lineHeight":"auto","fontSize":"28rpx","borderStyle":"solid"}'>{{detail.role}}</view>
				</view>

			</view>




			<view class="bottom-content cu-bar bg-white tabbar border shop" :style='{"padding":"0px","boxShadow":"rgb(0 0 0 / 0%) 0px 0px 12rpx","margin":"0px","borderColor":"rgb(204, 204, 204)","backgroundColor":"rgb(255, 255, 255)","borderRadius":"0px","borderWidth":"2rpx 0 0 0","width":"100%","borderStyle":"solid","height":"100rpx"}'>
				<view style="text-align: left;display: flex;">
				</view>
				<view style="text-align: right;">
                </view>
			</view>
		</view>

		<!-- 确认完成弹窗 -->
		<uni-popup class="popup-content" ref="popup" type="center">
			<form class="popup-form">
				<view class="cu-form-group margin-top">
					<picker @change="sfshChange" :value="sfshIndex" :range="sfshOptions">
						<view class="uni-input">{{detail.sfsh?detail.sfsh:'选择审核结果'}}</view>
					</picker>
				</view>
				<view class="cu-form-group">
					<!-- <view class="title">审核回复</view> -->
					<textarea style="width: 200px;" v-model="detail.shhf" placeholder="审核回复"></textarea>
					<!-- <input v-model="douyinId" placeholder="审核回复" name="input"></input> -->
				</view>
				<view class="btn-content">
					<button @tap="onCloseWinTap" class="cu-btn bg-cyan">取消</button>
					<button @tap="onFinishTap" class="cu-btn bg-red">确认</button>
				</view>
			</form>
		</uni-popup>

	</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				autoplaySwiper: {"delay":5000,"disableOnInteraction":false} ? true : false,
				intervalSwiper: {"delay":5000,"disableOnInteraction":false} ? 5000 : 5000,
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
                userid: '',
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: {},
				sfshIndex: -1,
				sfshOptions: ['通过','不通过'],
				count: 0,
				timer: null
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
			SecondToDate: function() {
				var time = this.count;
				if (null != time && "" != time) {
					if (time > 60 && time < 60 * 60) {
						time =
							parseInt(time / 60.0) +
							"分钟" +
							parseInt((parseFloat(time / 60.0) - parseInt(time / 60.0)) * 60) +
							"秒";
					} else if (time >= 60 * 60 && time < 60 * 60 * 24) {
						time =
							parseInt(time / 3600.0) +
							"小时" +
							parseInt(
								(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
							) +
							"分钟" +
							parseInt(
								(parseFloat(
										(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
									) -
									parseInt(
										(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
									)) *
								60
							) +
							"秒";
					} else if (time >= 60 * 60 * 24) {
						time =
							parseInt(time / 3600.0 / 24) +
							"天" +
							parseInt(
								(parseFloat(time / 3600.0 / 24) - parseInt(time / 3600.0 / 24)) *
								24
							) +
							"小时" +
							parseInt(
								(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
							) +
							"分钟" +
							parseInt(
								(parseFloat(
										(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
									) -
									parseInt(
										(parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
									)) *
								60
							) +
							"秒";
					} else {
						time = parseInt(time) + "秒";
					}
				}
				return time;
			}
		},
		async onLoad(options) {
			this.id = options.id;
            if(options.userid) {
                this.userid = options.userid;
            }
		},
		async onShow(options) {
			// 渲染数据
			this.init();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
			// 支付
			onPayTap(){
				uni.setStorageSync('paytable','users');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
			// 收藏
			// 跨表
			onAcrossTap(tableName,crossOptAudit,statusColumnName,tips,statusColumnValue){
				uni.setStorageSync('crossTable','users');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
			},
			// 获取详情
			async init(){
				let res = await this.$api.info('users', this.id);
				this.detail = res.data;
			},

			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				mescroll.endSuccess(mescroll.size, this.hasNext);

            },

			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url){
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							 window.open(url);
						}
					}
				});
			},
			//
			onCartTabTap() {
				this.$utils.tab('../shop-cart/shop-cart')
			},
			// 添加评论
			async onCommentTap() {
				this.$utils.jump(`../discussusers/add-or-update?refid=${this.id}`)
			},
			onSHTap() {
				this.$refs.popup.open()
			},
			// 完成审核
			async onFinishTap() {
				if(!this.detail.sfsh){
					this.$utils.msg('请选择审核状态');
					return
				}
				if(!this.detail.shhf){
					this.$utils.msg('请填写审核回复');
					return
				}
				if(this.detail.sfsh=="通过"){
					this.detail.sfsh = '是'
				}
				if(this.detail.sfsh=="不通过"){
					this.detail.sfsh = '否'
				}
				await this.$api.update('users', this.detail);
				this.$utils.msg('审核成功');
				this.$refs.popup.close();
			},
			// 关闭窗口
			onCloseWinTap() {
				this.$refs.popup.close()
			},
			sfshChange(e){
				console.log(this.detail)
				this.sfshIndex = e.target.value
				this.detail.sfsh = this.sfshOptions[this.sfshIndex]
			}
		}
	}
</script>

<style lang="scss">
	.container {
		// padding-bottom: 80upx;
	}

	.container:after {
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

	.swiper {
		width: 100%;
		height: 450upx;

		image {
			width: 100%;
		}
	}

	.detail-content {
		font-size: 28upx;
		color: #888888;
		// padding: 10upx 20upx;
		background: #FFFFFF;
		line-height: 45upx;

		.name {
			font-size: 38rpx;
			font-weight: blod;
			// margin-bottom: 20upx;
			padding-top: 20upx;
		}

		.price {
			font-size: 33rpx;
			color: red;
			// margin-top: 20upx;
		}
	}

	.time-content {
		background: #FFFFFF;
		padding: 30upx;
		font-size: 30upx;
		border-radius: 20upx;
		margin-top: 20upx;

		.header {
			font-size: 33upx;
			margin-bottom: 20upx;
		}
	}


	.bottom-content {
		position: fixed;
		bottom: 0;
		left: 0;
		width: 100%;

		button {
			margin: 0 0 0 20rpx !important;
			padding: 0 20rpx;
			box-shadow: 0 0 12rpx rgba(0,0,0,0);
		}
	}

	.comoment-header {
		display: flex;
		justify-content: space-between;
		align-items: center;
		padding-bottom: 12upx;

		.btn-comment-content {
			color: #DD514C;
			font-weight: bold;
			padding: 0 12upx;
		}
	}

	.comment-item {
		margin-bottom: 10upx;
		border-bottom: 1px solid #EEEEEE;
		padding-bottom: 20upx;

		.content {
			margin-left: 20upx;
			margin-top: 20upx;
		}
	}

	.icon {
		width: 50upx;
		height: 50upx;
	}

	.popup-content {
		.popup-form {
			background: #FFFFFF;
			margin-top: 20upx;
		}

		.btn-content {
			text-align: right;
			background: #FFFFFF;

			button {
				margin-left: 20upx;
				margin-right: 20upx;
				margin-bottom: 20upx;
			}
		}
	}

	.detail-list-item {
	  padding: 0 24upx;
	  box-sizing: border-box;
	  display: flex;
	  align-items: center;
	  height: 68upx;
	  border-bottom: 2upx solid #efefef;
	  background-color: #fff;

	  .lable {
	    font-size: 28upx;
	    color: #000;
	  }

	  .text {
	    flex: 1;
	    font-size: 24upx;
	    color: #FF00FF;
	    text-align: left;
	  }

	  &.favor {
	    .el-icon-star-on {
	      color: inherit;
	      font-size: inherit;
	    }
	  }
	}

	.detail-content .shop-title {
		padding: 20upx 24upx;
		box-sizing: border-box;
		line-height: 1.4;
	}

	.priceFavor {
		// height: 96upx !important;
	}

	.priceFavor .text {
		// font-size: 64upx !important;
		// color: red !important;
	}

	.priceFavor .icon {
		// font-size: 56upx !important;
		// text-align: right !important;
		// color: red !important;
	}
</style>
