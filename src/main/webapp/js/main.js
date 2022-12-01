$(".area-wrapper").on("click", (e) => {
    const rForm = document.getElementById("rHeadVal");
    let rVal = rForm.children[0].innerHTML;
    let k = $(".area-wrapper").width() / 2;
    let xVal = rVal * (e.offsetX - k) * 1.25 / k;
    let yVal = rVal * (k - e.offsetY) * 1.25 / k;
    $("input[name='form:xVal_input']").val(xVal);
    $("input[name='form:yVal']").val(yVal);
    document.getElementById("send_but").children[0].click();
})

