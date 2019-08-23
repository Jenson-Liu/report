 for (var key in data.data){
    var datahtml = " <tr onclick='on(this)' id='" +data.data[key][0]+
        "'>\n";
    for (var i=0; i<data.data[key].length; i++)
    {
        datahtml +=
            "<td>" +data.data[key][i] +
            "</td>\n";
    }
    datahtml +=   "        </tr>";
    $('#list').append(datahtml);
}