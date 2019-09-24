function resetImg(_fileName) {
    document.getElementById("goodsInfoPicImg").src = "upload/" + _fileName;
    document.getElementById("goodsInfoPic").value = _fileName;
}