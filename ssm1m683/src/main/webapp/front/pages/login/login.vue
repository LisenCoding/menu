<template>
	<view class="content">
		<view class="box" :style='{"padding":"48rpx","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"100%"}'>
			<view class="logo" :style='{"padding":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"0 0 24rpx","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'>
				<image :style='{"padding":"0","boxShadow":"0 0 0px #59f43e","margin":"100rpx auto 40rpx","borderColor":"#ccc","borderRadius":"40rpx","borderWidth":"2rpx","width":"160rpx","borderStyle":"solid","url":"http://codegen.caihongy.cn/20220211/a3f870a1e415404181abd4412b8482b7.jpg","isShow":true,"height":"160rpx"}' src='http://codegen.caihongy.cn/20220211/a3f870a1e415404181abd4412b8482b7.jpg' mode="aspectFill"></image>
			</view>
			<view class="uni-form-item uni-column" :style='{"padding":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"0 0 24rpx","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'>
				<input v-model="username" :style='{"padding":"0 24rpx","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(201, 201, 201, 1)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(167, 167, 167, 1)","textAlign":"left","borderRadius":"0","borderWidth":" 0 0 4rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}' type="text" class="uni-input" name="" placeholder="请输入账号" />
			</view>
			<view class="uni-form-item uni-column" :style='{"padding":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"0 0 24rpx","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'>
				<input v-model="password" :style='{"padding":"0 24rpx","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(201, 201, 201, 1)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(167, 167, 167, 1)","textAlign":"left","borderRadius":"0","borderWidth":" 0 0 4rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}' type="password" class="uni-input" name="" placeholder="请输入密码" />
			</view>
				<view class="uni-form-item uni-column" v-if="roleNum>1" :style='{"padding":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"0 0 24rpx","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'>
				<picker @change="optionsChange" :value="index" :range="options">
					<view class="uni-picker-type" :style='{"padding":"0 20rpx","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 1)","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","borderStyle":"solid"}'>{{options[index]}}</view>
				</picker>
			</view>
			<button class="btn-submit" @tap="onLoginTap" type="primary" :style='{"padding":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"#ccc","backgroundColor":"rgba(130, 163, 157, 1)","borderRadius":"8rpx","color":"rgba(255, 255, 255, 1)","borderWidth":"2rpx","width":"100%","fontSize":"32rpx","borderStyle":"solid","height":"88rpx"}'>登录</button>
			<view class="links" :style='{"padding":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"0 0 24rpx","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'>
												<view class="link-highlight" @tap="onRegisterTap('yonghu')" :style='{"padding":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"10rpx 0","borderColor":"#ccc","backgroundColor":"rgba(0,0,0,0)","color":"rgba(130, 163, 157, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"55%","lineHeight":"36rpx","fontSize":"24rpx","borderStyle":"solid"}'>注册用户</view>
				<!-- <view>|</view> -->
																																																				<view @tap="onForgetTap" :style='{"padding":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"#ccc","backgroundColor":"rgba(0,0,0,0)","color":"#999","textAlign":"right","borderRadius":"0","borderWidth":"0","width":"45%","lineHeight":"36rpx","fontSize":"24rpx","borderStyle":"solid"}'>忘记密码？</view>
			</view>
			<!-- <view class="links">
				<view @tap="onForgetTap" :style='{"padding":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"#ccc","backgroundColor":"rgba(0,0,0,0)","color":"#999","textAlign":"right","borderRadius":"0","borderWidth":"0","width":"45%","lineHeight":"36rpx","fontSize":"24rpx","borderStyle":"solid"}'>忘记密码？</view>
			</view> -->
		</view>
	</view>
</template>

<style>
	.btn-submit {
		height: auto !important;
		line-height: 88rpx;
	}
</style>

<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				username: '',
				password: '',
				codes: [{
				  num: 1,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 2,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 3,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 4,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}],
				options: [
					'请选择登录用户类型'
				],
                		optionsValues: [
					'',
                    			'yonghu',
				],
				index: 0,
				roleNum:0
			}
		},
		onLoad() {
			let options = ['请选择登录用户类型'];
			let menus = menu.list();
			this.menuList = menus;
			for(let i=0;i<this.menuList.length;i++){
				if(this.menuList[i].hasFrontLogin=='是'){
					options.push(this.menuList[i].roleName);
					this.roleNum++;
				}
			}
			if(this.roleNum==1) {
				this.index = 1;
			}	
			this.options = options;
			this.randomString(4)
			this.styleChange()
		},
		methods: {
			randomString(len = 4) {
			  const chars = [
			    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			    'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			    'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			    'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			    '3', '4', '5', '6', '7', '8', '9'
			  ]
			  const colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			  const sizes = ['28', '30', '32', '34', '36']
			
			  for (let i = 0; i < len; i++) {
			    // 随机验证码
			    const key = Math.floor(Math.random() * chars.length)
			    this.codes[i].num = chars[key]
			    // 随机验证码颜色
			    let code = '#'
			    for (let j = 0; j < 6; j++) {
			      const key = Math.floor(Math.random() * colors.length)
			      code += colors[key]
			    }
			    this.codes[i].color = code
			    // 随机验证码方向
			    let rotate = Math.floor(Math.random() * 30)
			    const plus = Math.floor(Math.random() * 2)
			    if (plus == 1) rotate = '-' + rotate
			    this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			    // 随机验证码字体大小
			    const size = Math.floor(Math.random() * sizes.length)
			    this.codes[i].size = sizes[size] +'rpx'
			  }
			},
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.loginFrom.content.input.backgroundColor
					// })
				})
			},
			onRegisterTap(tableName) {
                uni.setStorageSync("loginTable", tableName);
				this.$utils.jump('../register/register')
			},
			onForgetTap() {
				this.$utils.jump('../forget/forget')
			},
			async onLoginTap() {
                if (!this.optionsValues[this.index]) {
					this.$utils.msg('请选择登陆用户类型')
					return
				}
				let res = await this.$api.login(`${this.optionsValues[this.index]}`, {
					username: this.username,
					password: this.password
				});
                uni.removeStorageSync("useridTag");
				uni.setStorageSync("token", res.token);
				uni.setStorageSync("nickname",this.username);
				uni.setStorageSync("nowTable", `${this.optionsValues[this.index]}`);
				res = await this.$api.session(`${this.optionsValues[this.index]}`);
				// 保存用户id
				uni.setStorageSync("userid", res.data.id);
				if(res.data.vip) {
					uni.setStorageSync("vip", res.data.vip);
				}
				uni.setStorageSync("role", `${this.options[this.index]}`);
				this.$utils.tab('../index/index');
			},
			optionsChange(e) {
				this.index = e.target.value
			}
		}
	}
</script>

<style lang="scss" scoped>
	$color-primary: #b49950;

	.content {
		display: flex;
		justify-content: center;
		flex-direction: column;
		height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.content:after {
		position: fixed;
		top: 0;
		right: 0;
		left: 0;
		bottom: 0;
		content: '';
				background-image: url(http://codegen.caihongy.cn/20220210/5f9d2b3ffe6d4ca281568b5aec07779c.png);
				background-attachment: fixed;
		background-size: cover;
		background-position: center;
	}

	.logo {
		text-align: center;

		image {
			height: 200upx;
			width: 200upx;
			margin: 0 0 60upx;
		}
	}

	.uni-form-item {
		margin-bottom: 40upx;
		padding: 0;

		.uni-input {
			font-size: 30upx;
			padding: 7px 0;
		}
	}

	button[type="primary"] {
		background-color: $color-primary;
		border-radius: 0;
		font-size: 34upx;
		margin-top: 60upx;
	}

	.links {
		margin-top: 40upx;
		font-size: 26upx;
		color: #999;

		view {
			display: inline-block;
			vertical-align: top;
			margin: 0 10upx;
		}

		.link-highlight {
			margin: 0;
			color: $color-primary
		}
	}
	
	
</style>
