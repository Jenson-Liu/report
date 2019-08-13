'use strict';
function getsheets(filename) {
    var xlsx = require('xlsx');
    var path = require('path');
    let excelpath = path.resolve(__dirname, '../../static/lips');
    const workbook = xlsx.readFile(excelpath+'/'+filename);
    var arr=[];
    const sheetNames = workbook.SheetNames;
    for (var i=0; i<sheetNames.length; i++){
        arr.push(sheetNames[i]);
    }
    console.log(arr);
    return arr;
}
module.exports = {
    getsheets :getsheets
};
