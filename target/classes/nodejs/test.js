// var xlsx = require('node-xlsx');
// var fs = require('fs');
// //读取文件内容
// var obj = xlsx.parse(__dirname+'/1_Unique_eCATT.xlsx');
// var excelObj=obj[0].data;

// for(var i in excelObj){
//     var value=excelObj[i];
//     for(var j in value){
//         console.log(value[j]);
//     }
// }

var xlsx = require('xlsx');
console.log(__dirname+'/2_BC_Set.XLSX');
const workbook = xlsx.readFile('/Users/i501695/IdeaProjects/report/src/main/resources/nodejs/service/2_BC_Set.XLSX');
// 获取 Excel 中所有表名
const sheetNames = workbook.SheetNames; // 返回 ['sheet1', 'sheet2']
// 根据表名获取对应某张表
const worksheet = workbook.Sheets[sheetNames[0]];
console.log(sheetNames);