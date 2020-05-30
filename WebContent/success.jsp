<%@page import="a.beanyBean"%>  
<%@page import="java.util.*"%>
<%
beanyBean bean=(beanyBean)request.getAttribute("bean");
out.println("Search phrase: "+bean.getSearch());
out.print("<br>");
out.println("Bearbase result:");
out.print("<ul>");
for (int i=0;i<bean.getBearResult().size();i++)
{
    out.println("<li>"+bean.getBearResult().get(i)+"</li>");
}
out.print("</ul>");
out.println("Ikea result:");
out.print("<ul>");
for (int i=0;i<bean.getIkeaResult().size();i++)
{
    out.println("<li>"+bean.getIkeaResult().get(i)+"</li>");
}
out.print("</ul>");
out.println("Masterscp result:");
out.print("<ul>");
for (int i=0;i<bean.getMastersResult().size();i++)
{
    out.println("<li>"+bean.getMastersResult().get(i)+"</li>");
}
out.print("</ul>");
%>