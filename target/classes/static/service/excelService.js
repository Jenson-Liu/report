'use strict';

/**
 * 指定文件位置获取相应的所有sheet
 * @param filename
 * @returns {[]}
 */
function getSheets(filename) {
    let Read = require('xlsx');
    let path = require('path');
    let excelPath = path.resolve(__dirname, '../../static/lips');
    const workbook = Read.readFile(excelPath+'/'+filename);
    let arr=[];
    const sheetNames = workbook.SheetNames;
    for (let i=0; i<sheetNames.length; i++){
        arr.push(sheetNames[i]);
    }
    return arr;
}

/**
 * 获取指定sheet的column
 * @param filename
 * @param sheetName
 * @returns {[]}
 */
function getColumns(filename,sheetName){
    var xlsx = require('node-xlsx');
    var fs = require('fs');
    let path = require('path');
    let excelPath = path.resolve(__dirname, '../../static/lips');
    var obj = xlsx.parse(excelPath+'/'+filename);
    let sheet;
    for(var c in obj){
        if(obj[c].name == sheetName){
            sheet = obj[c];
            break;
        }
    }
    let arr=[];
    const columnsNames = sheet.data[0];
    for (let i=0; i<columnsNames.length; i++){
        arr.push(columnsNames[i]);
    }
    return arr;
}
module.exports = {
    getSheets :getSheets,
    getColumns :getColumns
};
