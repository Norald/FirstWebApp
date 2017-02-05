<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>


<div class="pdf_viewer">
    <applet CODE="EmbedPDF.class" archive="<%=session.getServletContext().getContextPath()%>/jars/EmbedPDF.jar" WIDTH="850" HEIGHT="900">
        <!-- The URL of the PDF document that we want to show: -->

        <param name="pdf" value="<%= request.getContextPath()%>/PdfContentServlet?index=<%=request.getParameter("index")%>&session_id=<%=request.getSession().getId()%>"/>
        <!-- Whether users may open the PDF document in a new window: -->
        <param name="enableOpenWindow" value="true"/>

        <!-- Whether the PDF is rendered with subpixel-antialiasing (may be slow and needs more memory) -->
        <param name="enableSubpixAA" value="true"/>


        <!-- The following parameters are recommended to improve usability and
             performance of the applet when run with Sun's Java Plugin: -->

        <!-- whether language-specific texts shall be looked up on the server. -->
        <param name="codebase_lookup" value="false"/>

        <!-- whether the code of the applet shall be shared with other applets. -->
        <param name="classloader_cache" value="false"/>

        <!-- Whether the server provides a highly compressed .pack.gz-version of the applet.
             The amount of memory that the applet may use (128m is 128 mega bytes).
        -->
        <param name="java_arguments" value="-Djnlp.packEnabled=true -Xmx128m"/>

        <!-- the splash screen to show, while the applet loads. -->
        <%--<param name="image" value="<%=getServletContext().getContextPath()%>/images/splash.gif"/>--%>

        <!-- the border of the splash screen. -->
        <param name="boxborder" value="false"/>

        <!-- whether the splash screen shall be centered. -->
        <param name="centerimage" value="true"/>

    </applet>
</div>
</body>
</html>
