/**
 * 
 */

/**
 * 
 */

   $("#btn").click(function() {
      var title = $("#title").val();
      var writer = $("#writer").val();
      
      var ch1 = false;
      var ch2 = false;
      
      if(title != ''){
         ch1 = true;
      }
      
      if(writer != ''){
         ch2 = true;
      }
      
      if(ch1 && ch2){
         $("#frm").submit();
         alert("작성 완료");
      }else{
         alert("필수 항목을 입력해주세요.");
      }

   });