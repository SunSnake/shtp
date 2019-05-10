<template>
  <div class="publicback">
    <div class="upper">
      <el-form ref="productForm" :model="productForm" label-width="90px">
        <div class="description">
          <el-form-item label="商品描述：">
            <el-input type="textarea" v-model="productForm.description" :rows="8" ref="desc"></el-input>
          </el-form-item>
          <el-form-item label="商品价格：">
            <el-input v-model="productForm.price" ref="price"></el-input>
          </el-form-item>
        </div>
        <div class="pic">
          <img :src="avatar" style="width: 200px;height: 200px;background-color: #eeeeee"/>
          <input type="file" name="file" ref="avatarInput" @change="changeImage" accept="image/png,image/gif,image/jpeg" style="margin-left: 50px">
        </div>
        <el-form-item class="buttons">
          <el-button type="primary" @click="onSubmit">立即创建</el-button>
          <el-button @click="clearInput">清除</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="seg">已发布</div>
    <PersonalizedList></PersonalizedList>
  </div>

</template>

<script>
    import PersonalizedList from "../component/PersonalizedList";
    import axios from 'axios';
    export default {
      name: 'Product',
      components: {PersonalizedList},
      data() {
        return {
          productForm: {
            description: '',
            price: ''
          },
          avatar: ''
        };
      },
      methods: {
        changeImage() {
          var file = this.$refs.avatarInput.files[0]
          var reader = new FileReader()
          var that = this
          reader.readAsDataURL(file)
          reader.onload = function() {
            that.avatar = this.result
          }
        },
        clearInput(){
          this.$refs.desc.value = '';
          this.$refs.price.value = '';
          this.$refs.avatarInput.value = ''
        },
        onSubmit(){
          if (this.$refs.desc.value&&(this.$refs.price.value&&this.$refs.avatarInput.value)) {
            let _this = this;
            let config = {
              headers: {
                'Content-Type': 'multipart/form-data'
              }
            }
            let formData = new FormData()
            formData.append('userId', this.$store.state.user.id)
            formData.append('description', this.productForm.description)
            formData.append('price', this.productForm.price)
            formData.append('file', this.$refs.avatarInput.files[0])
            axios.post('/product/unit/submit', formData, config).then(resp=> {
              this.$alert('发布商品成功', '提示', {
                confirmButtonText: '确定',
                type: 'warning'
              }).then(()=>{
                _this.clearInput();
                window.location.reload();
              })
            });
          } else {
            this.$alert('请输入发布内容', '提示', {
              confirmButtonText: '确定',
              type: 'warning'
            });
          }
        }
      }
    }
</script>

<style scoped>
  @import "../styles/public.css";
  @import "../styles/seg.css";
  @import "../styles/upperDiv.css";

  .description{
    width: 700px;
  }
  .pic{
    position: relative;
    margin-left: 700px;
    margin-top: -264px;
  }

  .buttons{
    margin-top: 50px;
  }
</style>
