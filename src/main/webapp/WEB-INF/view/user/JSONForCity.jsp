

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<c:set var="flag" value="0"></c:set>
[
<c:forEach items="${sessionScope.l_city}" var="cityvo">
<c:if test="${flag eq 1}">
   ,{
    "cityId":${cityvo.id}, 
    "cityName":"${cityvo.cityName}"
   }
   </c:if>
   <c:if test="${flag eq 0}">
   {
    "cityId":${cityvo.id}, 
    "cityName":"${cityvo.cityName}"
   }
   <c:set var="flag" value="1"></c:set>
  </c:if>
 </c:forEach>
]


           
