<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h1>ICD Search Results</h1>
<p>
	<a id="changeSearchLink" href="icd/search?searchString=${searchCriteria.searchString}&searchType=${searchCriteria.searchType}&pageSize=${searchCriteria.pageSize}">Change Search</a>
	<script type="text/javascript">
		Spring.addDecoration(new Spring.AjaxEventDecoration({
			elementId: "changeSearchLink",
			event: "onclick",
			popup: true,
			params: {fragments: "searchForm"}		
		}));
	</script>
</p>
<div id="icdResults">
<c:if test="${not empty icd}">
	<table class="summary">
		<thead>
			<tr>
				<th>ICD9 Code</th>
				<th>Description</th>
				<th>Abbreviation</th>


			</tr>
		</thead>
		<tbody>
			<c:forEach var="icd9" items="${icd.icd9s}">
				<tr>
					<td>${icd9.icd9Code}</td>
					<td>${icd9.icd9Description}</td>
					<td>${icd9.icd9Abbreviation}</td>

				</tr>
			</c:forEach>
			<c:if test="${empty icd9s}">
				<tr>
					<td colspan="5">No ICD9 Code found</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<table class="summary">
		<thead>
			<tr>
				<th>ICD10 Code</th>
				<th>Label3</th>
				<th>Label4</th>
				<th>Label5</th>
				<th>Label6</th>
				<th>Label7</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="icd10" items="${icd.icd10s}">
				<tr>
					<td>${icd10.icd10Code}</td>
					<td>${icd10.icd10Label3}</td>
					<td>${icd10.icd10Label4}</td>
					<td>${icd10.icd10Label5}</td>
					<td>${icd10.icd10Label6}</td>
					<td>${icd10.icd10Label7}</td>
				</tr>
			</c:forEach>
			<c:if test="${empty icd10s}">
				<tr>
					<td colspan="5">No ICD10 Code found</td>
				</tr>
			</c:if>
		</tbody>
	</table>

</c:if>
</div>	

