<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="product">
    <h2>
        <c:if test="${product['new']}">New </c:if> Product
    </h2>
    <form:form modelAttribute="product" class="form-horizontal" id="add-product-form">
        <div class="form-group has-feedback">
            <petclinic:inputField label="Nombre" name="name"/>
            <petclinic:inputField label="Precio" name="price"/>

            <petclinic:selectField name="product_type.name" label="Tipo" names="${tipeList}"size="2" />
                            <div class="form-group">
                                <label class="col-sm-offset-1 col-sm-2 control-label">Tipo:</label>
                                <div class="col-sm-offset-1 col-sm-10">
                                    <label class="checkbox-inline">
                                        <form:checkbox path="tipo" name="tipo" value="Food" id="food"/>
                                        Food
                                    </label>
                                    <label class="checkbox-inline">
                                        <form:checkbox path="tipo" name="tipo" value="Accessories" id="accessories"
                                        />
                                        Accessories
                                    </label>
                                    
                                </div>
                            </div>
       
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${product['new']}">
                        <button class="btn btn-default" type="submit">Add product</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update product</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</petclinic:layout>
