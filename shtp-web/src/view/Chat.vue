<template>
  <div class="publicback">
    <el-tabs v-model="activeName" @tab-click="handleClick" style="margin-top: 10px">
      <el-tab-pane label="系统通知" name="notification"><nf></nf></el-tab-pane>
      <el-tab-pane label="好友聊天" name="chat"><fc></fc></el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
  import FriendChat from '@/view/FriendChat'
  import Notification from '@/view/Notification'
  export default {
    data() {
      return {
        activeName: 'notification'
      };
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    },
    components:{
      'fc':FriendChat,
      'nf':Notification
    }
  };
</script>
<style>
  @import "../styles/public.css";
</style>
