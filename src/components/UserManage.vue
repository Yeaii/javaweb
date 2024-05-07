<template>
<div>
<h2 align="center">欢迎进入作者管理界面</h2>
  <el-button type="primary" icon="el-icon-plus" @click="dialogFormVisible = true">新增
  </el-button>

<el-dialog title="新增作者" :visible.sync="dialogFormVisible">
  <el-form :model="form">
    <el-form-item label="活动名称" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="省份" :label-width="formLabelWidth">
      <el-select v-model="form.region" placeholder="请选择省份">
        <el-option label="区域一" value="shanghai"></el-option>
        <el-option label="区域二" value="beijing"></el-option>
      </el-select>
    </el-form-item>
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
  </div>
</el-dialog>



  <el-button type="primary" icon="el-icon-search" style="float:right">搜索</el-button>
  <el-input placeholder="请输入内容"  style="width: 300px;float:right">
    <i slot="prefix" class="el-input__icon el-icon-search"></i>
  </el-input>
  <el-table

      :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
      border
    style="width: 100%"  height="600px">
     
     <el-table-column
      type="index"
      label="序号"
      width="50">
    </el-table-column>

    <el-table-column
      prop="date"
      label="日期"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="province"
      label="省份"
      width="120">
    </el-table-column>
    <el-table-column
      prop="city"
      label="市区"
      width="120">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址"
      width="300">
    </el-table-column>
    <el-table-column
      prop="zip"
      label="邮编"
      width="140">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
        <el-button type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination align='center'
                 @size-change="handleSizeChange"
                 @current-change="handleCurrentChange"
                 :current-page="currentPage"
                 :page-sizes="[1,5,10,20]"
                 :page-size="pageSize"
                 layout="total, sizes, prev, pager, next, jumper"
                 :total="tableData.length">
  </el-pagination>


</div>
</template>
<script>
 export default {
       data() {
         const item = {
           date: '2016-05-02',
           name: '王小虎',
           province: '上海',
           city: '普陀区',
           address: '上海市普陀区金沙江路 1518 弄',
           zip: 200333
         };
         return {
           tableData: Array(30).fill(item),
           currentPage: 1, // 当前页码
           total: 20, // 总条数
           pageSize: 2 ,// 每页的数据条数


           dialogFormVisible: false,
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth: '120px'
      
         }
         
       }
   ,
   methods: {
     handleClick(row) {
       console.log(row);
     },
     //每页条数改变时触发 选择一页显示多少行
     handleSizeChange(val) {
       console.log(`每页 ${val} 条`);
       this.currentPage = 1;
       this.pageSize = val;
     },
     //当前页改变时触发 跳转其他页
     handleCurrentChange(val) {
       console.log(`当前页: ${val}`);
       this.currentPage = val;
     }
   },
   
    }


</script>

<style scoped>

</style>
