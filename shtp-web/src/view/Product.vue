<template>
  <div class="publicback">
    <div class="upper">
      <el-form ref="productForm" :model="productForm" label-width="90px">
        <div class="description">
          <el-form-item label="商品描述：">
            <el-input type="textarea" v-model="productForm.description" :rows="8"></el-input>
          </el-form-item>
          <el-form-item label="商品价格：">
            <el-input v-model="productForm.price"></el-input>
          </el-form-item>
        </div>
        <div class="pic">
          <el-form-item v-model="productForm.imageUrl">
            <img id="portrait" style="width: 200px;height: 200px;background-color: #eeeeee"/>
            <input type="file" id="saveImage" accept="image/png,image/gif,image/jpeg">
            <!--<el-upload
              class="avatar-uploader"
              action=""
              :show-file-list="false"
              :before-upload="beforeAvatarUpload">
              <img src="" alt="" id="portrait" style="width: 300px;height: 200px;background-color: #eeeeee"/>
              <img v-if="form.imageUrl" :src="form.imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>-->
          </el-form-item>
        </div>

        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即创建</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="seg">已发布</div>
    <ProductList></ProductList>
  </div>

</template>

<script>
    import ProductList from "../component/ProductList";
    export default {
      name: 'Product',
      components: {ProductList},
      data() {
        return {
          productForm: {
            description: '',
            price: '',
            imageUrl: ''
          }
        };
      },

      mounted: function () {
        this.great();
      },
      methods: {
        onSubmit(){
          var _this = this;
          this.loading = true;
          this.postRequest('/product/unit/submit', {
            description: this.productForm.description,
            price: this.productForm.price,
            imageUrl: this.imageUrl
          }).then(resp=> {
            _this.loading = false;
            if (resp && resp.status == 200) {
            }
          });
        },
        great() {
          document.getElementById('saveImage').onchange = function () {
            var imgFile = this.files[0];
            var fr = new FileReader();
            var _this = this;
            fr.onload = function () {
              document.getElementById('portrait').src = fr.result;
            };
            fr.readAsDataURL(imgFile);
          }
        },
        changeImage(e) {
          var file = e.target.files[0]
          var reader = new FileReader()
          var that = this
          reader.readAsDataURL(file)
          reader.onload = function (e) {
            that.avatar = this.result
          }
        }
      }
    }
</script>

<style scoped>
  @import "../styles/public.css";
  @import "../styles/seg.css";
  @import "../styles/upperDiv.css";

  .upload-imgs{margin: 10px 0 30px 0;overflow: hidden;font-size: 0;}
  .upload-imgs li{position: relative;width: 118px;height: 118px;font-size: 14px;display: inline-block;padding: 10px;margin-right: 25px;border: 2px dashed #ccc;text-align: center;vertical-align: middle;}
  .upload-imgs li:hover{border-color: $them-color;}
  .upload-imgs .add{display: block;background-color: #ccc;color: #ffffff;height: 94px;padding: 8px 0;}
  .upload-imgs .add .iconfont{padding: 10px 0;font-size: 40px;}
  .upload-imgs li:hover .add{background-color: $them-color;}
  .upload-imgs li .upload{position: absolute;top: 0;bottom: 0;left: 0;right: 0;width: 118px;height: 118px;}
  .upload-imgs .img{position: relative;width: 94px;height: 94px;line-height: 94px;}
  .upload-imgs .img img{vertical-align: middle;}
  .upload-imgs .img .close{display: none;}
  .upload-imgs li:hover .img .close{display: block;position: absolute;right: -6px;top: -10px;line-height: 1;font-size: 22px;color: #aaa;}

  .description{
    width: 700px;
  }
  .pic{
    position: relative;
    margin-left: 700px;
    margin-top: -264px;
  }
  .avatar-uploader {
    border: 1px dashed darkgray;
    border-radius: 6px;
    cursor: pointer;
    width: 180px;
  }
  .avatar-uploader:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
