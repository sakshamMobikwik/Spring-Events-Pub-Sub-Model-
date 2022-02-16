<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page session="true" %>
<%@ page
        import="org.springframework.security.core.Authentication,org.springframework.security.core.context.SecurityContextHolder" %>
<html>
<head>
    <title>Login Page</title>
    <link href="css/CSSTableGenerator.css" rel="stylesheet" type="text/css">
    <script>
      function signup() {
        location.href = "<%=request.getContextPath()%>/signup.do";
      }
      function validateCredentials() {
          var currentUrl = window.location.href;
          var inputs =  document.forms["loginForm"].getElementsByTagName("input");
          var filteredInputs = new Array();
          for(let i=0;i<inputs.length;i++) {
              if(inputs[i].getAttribute("type") == "password" || inputs[i].getAttribute("type") == "text") {
                  filteredInputs.push(inputs[i]);
              }
          }
          for(let i=0;i<filteredInputs.length;i++) {
              filteredInputs[i].removeAttribute("style");
          }
          if(currentUrl.indexOf("?") != -1) {
              if(currentUrl.substring(currentUrl.indexOf("?")+1, currentUrl.length) == "error=true") {
                   for(let i=0;i<filteredInputs.length;i++) {
                       filteredInputs[i].setAttribute("style","border:1px solid red;");
                   }
                   alert("Invalid Credentials");
                   return;
              }
              document.loginForm.j_username.focus();
          } else {
              document.loginForm.j_username.focus();
          }
      }
    </script>
</head>

<body onload='validateCredentials()'>

<div class='CSSTableGenerator'>
    <form name='loginForm'
          action="<%=request.getContextPath()%>/j_spring_security_check"
          method='POST'>
        <table>
            <tr>
                <td colspan=2>Login with Username and Password<br/></td>
            </tr>
            <tr>
                <td>User:</td>
                <td><input type='text' name='j_username' onkeydown="this.removeAttribute('style');"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='j_password' onkeydown="this.removeAttribute('style');"/></td>
            </tr>
            <tr>
                <!-- <td><input type="button" value="SignUp" onclick="signup()"></td> -->
                <td colspan=2><input name="submit" type="submit" value="submit"/></td>
            </tr>
            <tr>
                <td colspan='2'><input type="hidden"
                                       name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>
