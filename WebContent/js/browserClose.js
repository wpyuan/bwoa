/*
 * 获取浏览器或者页面关闭事件
 */
window.onbeforeunload = onbeforeunload_handler;     
window.onunload = onunload_handler;     
    function onbeforeunload_handler()  
    {   
    	$.ajax({
    		type:"post",
    		url:"/oa/home/close.do",
    		async:false
    	});
    }     
         
    function onunload_handler()  
    {     
        var warning="谢谢光临";     
        alert(warning);     
    }