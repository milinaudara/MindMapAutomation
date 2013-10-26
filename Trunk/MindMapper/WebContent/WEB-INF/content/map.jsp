<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Map</title>
<script src="sys_js/jquery-1.10.2.min.js"></script>
<script>
/*When document is loaded, attach following function to the Onclick event of all the forms decorated with class=UserInputs*/
 
    $(document).ready(function ($) {
        /* attach a submit handler to the form */
        $("form.UserInputs").submit(function (event) {
 
            /* stop form from submitting normally */
            event.preventDefault();
 
            /* get some values from elements on the page: */
            var $form = $(this);
 
            var url = $form.attr('action');
            var data = $form.serialize()
//Here I call the ajax and post the data
            $.ajax({
                type: "POST",
                dataType: "json",
                url: url,
                data: data,
                success: function (output) {
                  alert(output.inputText);
                },
                error: function (xhr, status, error) {                   
                }
            });
        });
        return false;
    });
        </script>
</head>
<body>
<form action="<s:url value="map/map-process"/>" class="UserInputs" method="post">    
  Map Id    <input type="text" name="mapId" id /> 
  Input Text <input type="text" name="inputText" />
   <button id="btnFrmPost1" >Post</button>
</form>

</body>
</html>