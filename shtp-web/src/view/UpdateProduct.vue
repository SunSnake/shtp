<template>
  <div class="publicback">
    <div class="upper">
      <el-form ref="productForm" :model="productForm" label-width="90px">
        <div class="description">
          <el-form-item label="修改描述：">
            <el-input v-model="productForm.description" ref="desc"></el-input>
          </el-form-item>
          <el-form-item label="修改价格：">
            <el-input v-model="productForm.price" ref="price"></el-input>
          </el-form-item>
        </div>
        <div class="pic">
          <img :src="avatar" style="width: 200px;height: 200px;background-color: #eeeeee"/>
          <input type="file" name="file" ref="avatarInput" @change="changeImage" accept="image/png,image/gif,image/jpeg" style="margin-left: 50px">
        </div>
        <el-form-item class="buttons">
          <el-button type="primary" @click="onSubmit">立即更新</el-button>
          <el-button @click="clearInput">清除</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  export default {
    data() {
      return {
        productForm: {
          description: this.$route.query.description,
          price: this.$route.query.price
        },
        avatar: this.$route.query.imageUrl
      };
    },
    methods:{
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
        let _this = this;
        let config = {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        }
        let formData = new FormData()
        formData.append('id', this.$route.query.id)
        formData.append('description', this.productForm.description)
        formData.append('price', this.productForm.price)
        formData.append('file', this.$refs.avatarInput.files[0])
        axios.post('/product/unit/updateProduct', formData, config).then(resp=> {
          this.$alert('更新成功', '提示', {
            confirmButtonText: '确定',
            type: 'warning'
          }).then(()=>{
            _this.$router.push({
              path: `/Product`
            })
          })
        });
      }
    }
  }
</script>

<style>
  @import "../styles/public.css";
  @import "../styles/upperDiv.css";
  .description{
    width: 700px;
  }
  .pic{
    position: relative;
    margin-left: 700px;
    margin-top: -200px;
  }
</style>
