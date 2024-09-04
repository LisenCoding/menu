<template>
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
    <view class="cu-bar bg-white search" :style="[{top:CustomBar + 'px'}]">
			<picker v-if="queryList.length>1" mode="selector" :range="queryList" range-key="queryName" :value="queryIndex" @change="queryChange" style="padding-left: 20upx;">
				<view><image style="width: 20upx;height: 33upx;" src="../../static/center/to.png"></image></view>
			</picker>

                  			<view v-if="queryIndex==0" class="search-form round">
				<text class="cuIcon-search"></text>
				<input v-model="searchForm.username" type="text" placeholder="用户名" ></input>
			</view>
                                    
			<view class="action">
				<button @tap="search" :style="{width:'auto',borderRadius:'8rpx',height:'80rpx',fontSize:'28rpx',color:'#fff',backgroundColor:btnColor[0],borderColor:btnColor[0]}" class="cu-btn shadow-blur round">搜索</button>
			</view>
		</view>

		<view :style="1 != 1 ? 'display: flex;' : ''">
      
            <!-- 样式1 -->
            <view class="uni-product-list" :style='{"padding":"20rpx 0","boxShadow":"0 0 12rpx rgba(255,0,0,0)","margin":"0","borderColor":"red","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":0,"borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' style="box-sizing: border-box;">
        <view @tap="onDetailTap(product)" class="uni-product" :style='{"padding":"0px 20rpx 0","boxShadow":"0 0 12rpx rgba(255,0,0,0)","margin":"0 1% 20rpx 2%","borderColor":"rgba(130, 163, 157, 1)","backgroundColor":"#fff","borderRadius":"20rpx","borderWidth":"2rpx","width":"47%","borderStyle":"solid","height":"auto"}' v-for="(product,index) in list" :key="index">
                                                                                <view style="display: flex;justify-content: space-between;">
            <text v-if="userid && isAuth('users','修改')" class="cuIcon-edit" @click.stop="onUpdateTap(product.id)">修改</text>
            <text v-if="!userid && isAuthFront('users','修改')" class="cuIcon-edit" @click.stop="onUpdateTap(product.id)">修改</text>
            <text v-if="userid && isAuth('users','删除')" class="cuIcon-delete" @click.stop="onDeleteTap(product.id)">删除</text>
            <text v-if="!userid && isAuthFront('users','删除')" class="cuIcon-delete" @click.stop="onDeleteTap(product.id)">删除</text>
          </view>
        </view>
      </view>
            <!-- 样式2 -->
            <!-- 样式3 -->
            <!-- 样式4 -->
            <!-- 样式5 -->
            
      		</view>

		<button :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","margin":"0","backgroundColor":"rgba(130, 163, 157, 1)","borderColor":"rgba(130, 163, 157, 1)","borderRadius":"80rpx","color":"#fff","borderWidth":"1","width":"80%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-if="userid && isAuth('users','新增')" class="add-btn" @click="onAddTap()">新增</button>
		<button :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","margin":"0","backgroundColor":"rgba(130, 163, 157, 1)","borderColor":"rgba(130, 163, 157, 1)","borderRadius":"80rpx","color":"#fff","borderWidth":"1","width":"80%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-if="!userid && isAuthFront('users','新增')" class="add-btn" @click="onAddTap()">新增</button>

	</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				queryList:[
					{
						queryName:"用户名",
					},
				],
				sactiveItem: {"padding":"0 28rpx","boxShadow":"0 0 12rpx rgba(0,0,0,.3)","margin":"0 12rpx","borderColor":"rgba(0,0,0,1)","backgroundColor":"rgba(130, 163, 157, 1)","color":"#fff","borderRadius":"8rpx","borderWidth":"0","width":"auto","lineHeight":"70rpx","fontSize":"28rpx","borderStyle":"solid"},
				sitem: {"padding":"0 20rpx","boxShadow":"0 0 12rpx rgba(0,0,0,.3)","margin":"0 12rpx","borderColor":"rgba(0,0,0,1)","backgroundColor":"rgba(161, 161, 161, 1)","color":"rgba(255, 255, 255, 1)","borderRadius":"8rpx","borderWidth":"0","width":"auto","lineHeight":"70rpx","fontSize":"28rpx","borderStyle":"solid"},
				queryIndex: 0,
				list: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{},
				CustomBar: '0'
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onShow() {
			this.btnColor = this.btnColor.sort(()=> {
                                return (0.5-Math.random());
                        });
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		onLoad(options) {
            if(options.userid) {
                this.userid=options.userid;
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		methods: {
			//查询条件切换
			queryChange(e) {
				this.queryIndex=e.detail.value;
				this.searchForm.username="";
			},
			//类别搜索
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size
				}


				if(this.searchForm.username){
					params['username'] = '%' + this.searchForm.username + '%'
				}



                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`users`, params);
                } else {
                    res = await this.$api.list(`users`, params);
                }
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			// 修改
			onUpdateTap(id){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('users', JSON.stringify([id]));
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.mescroll.resetUpScroll()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size
				}
				if(this.searchForm.username){
					searchForm['username'] = '%' + this.searchForm.username + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`users`, searchForm);
                } else {
                    res = await this.$api.list(`users`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
			}
		}
	};
</script>

<style>
	/* product */
	page {
		background: #EEEEEE;
	}

	view {
		font-size: 28upx;
	}


	.uni-product-list {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
		flex-direction: row;
		margin-top: 0upx;
		// justify-content: space-around;
	}

	.uni-product {
		padding: 10upx;
		margin: 10upx;
		display: flex;
		flex-direction: column;
		background: #FFFFFF;
	}

	.image-view {
		height: 330upx;
		width: 330upx;
		margin: 12upx 0;
	}

	.uni-product-image {
		height: 330upx;
		width: 330upx;
	}

	.uni-product-title {
		width: 300upx;
		word-break: break-all;
		display: -webkit-box;
		overflow: hidden;
		line-height: 1.5;
		text-overflow: ellipsis;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 2;
	}

	.uni-product-price {
		margin-top: 10upx;
		font-size: 28upx;
		line-height: 1.5;
		position: relative;
	}

	.uni-product-price-original {
		color: #e80080;
	}

	.uni-product-price-favour {
		color: #888888;
		text-decoration: line-through;
		margin-left: 10upx;
	}

	.uni-product-tip {
		position: absolute;
		right: 10upx;
		background-color: #ff3333;
		color: #ffffff;
		padding: 0 10upx;
		border-radius: 5upx;
	}

	uni-image > div, uni-image > img {
		width: 100%;
		height: 140px;
		object-fit: cover;
	}

	.add-btn {
		position: fixed;
		left: 30upx;
		right: 30upx;
		// #ifndef MP
		bottom: 106upx;
		// #endif
		// #ifdef MP-WEIXIN
		bottom: 16upx;
		// #endif
		z-index: 95;
		display: flex;
		align-items: center;
		justify-content: center;
		width: 690upx;
		height: 80upx;
		font-size: 32upx;
		color: #fff;
		background-color: red;
		border-radius: 10upx;
		box-shadow: 1px 2px 5px rgba(219, 63, 96, 0.4);
	}

	.list {
		padding: 20upx 20upx 20upx;
	}

	.listm {
		background: #fff;
		border-radius: 15upx;
		box-shadow: 0 0 2upx rgba(0, 0, 0, 0.1);
		margin-bottom: 20upx;
		padding: 30upx;
	}

	.listmpic {
		border-radius: 10upx;
		width: 166upx;
		margin-right: 20upx;
	}

	.listmr {
		// width: 460upx;
		display: inline-block;
		flex: 1;
		display: flex;
		justify-content: space-between;
		flex-direction: column;
	}

  .news-box6 .dian::before {
    content: "";
    display: block;
    width: 8px;
    height: 8px;
    background-color: red;
    position: absolute;
    top: -4px;
    left: 50%;
    transform: translateX(-50%);
    border-radius: 100%;
    z-index: 1;
  }

  .hide1 {
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 1;
    line-clamp: 1;
    -webkit-box-orient: vertical;
  }

  .hide2 {
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    line-clamp: 2;
    -webkit-box-orient: vertical;
  }

  .hide4 {
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 4;
    line-clamp: 4;
    -webkit-box-orient: vertical;
  }
</style>
