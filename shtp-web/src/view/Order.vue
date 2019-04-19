<template>
  <div class="publicback">
    <div class="upper">
      <el-form ref="form" :model="form" label-width="90px">
        <div class="description">
          <el-form-item label="商品描述：">
            <el-input type="textarea" v-model="form.desc" :rows="8"></el-input>
          </el-form-item>
          <el-form-item label="商品价格：">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
        </div>
        <div class="pic">
          <el-form-item>
            <el-upload
              class="avatar-uploader"
              action="https://jsonplaceholder.typicode.com/posts/"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
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
      name: 'Order',
      components: {ProductList},
      data() {
        return {
          imageUrl: '',
          form: {
            name: '',
            desc: ''
          }
        };
      },
      methods: {
        handleAvatarSuccess(res, file) {
          this.imageUrl = URL.createObjectURL(file.raw);
        },
        beforeAvatarUpload(file) {
          const isJPG = file.type === 'image/jpeg';
          const isLt2M = file.size / 1024 / 1024 < 2;

          if (!isJPG) {
            this.$message.error('上传头像图片只能是 JPG 格式!');
          }
          if (!isLt2M) {
            this.$message.error('上传头像图片大小不能超过 2MB!');
          }
          return isJPG && isLt2M;
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
