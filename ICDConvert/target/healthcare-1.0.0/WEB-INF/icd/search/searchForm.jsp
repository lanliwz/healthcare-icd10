<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<h1>Search ICD</h1>

<c:url var="hotelsUrl" value="/icd"/>
<form:form modelAttribute="searchCriteria" action="${hotelsUrl}" method="get" cssClass="inline">
    <span class="errors span-18">
    	<form:errors path="*"/>
    </span>
	<fieldset>
		<div class="span-7">
			<label for="searchString">Search String:</label>
			<form:input id="searchString" path="searchString"/>
			<script type="text/javascript">
				Spring.addDecoration(new Spring.ElementDecoration({
					elementId : "searchString",
					widgetType : "dijit.form.ValidationTextBox",
					widgetAttrs : { promptMessage : "Search ICD by ICD-9 code, keywords, etc." }}));
			</script>
		</div>
		<div class="span-5">
			<div>
				<label for="SearchType">Search Type:</label>
				<form:select id="SearchType" path="SearchType">
					<form:option label="ICD-9 Code" value="icd9"/>
					<form:option label="ICD-10 Code" value="icd10"/>
					<form:option label="Keywords" value="keywords"/>
				</form:select>
			</div>
		</div>
		<div class="span-4">
			<div>
				<label for="pageSize">Maximum results:</label>
				<form:select id="pageSize" path="pageSize">
					<form:option label="5" value="5"/>
					<form:option label="10" value="10"/>
					<form:option label="20" value="20"/>
				</form:select>
			</div>
		</div>
		<div class="span-3 last">
			<button type="submit">Find ICD</button>
		</div>		
    </fieldset>
</form:form>