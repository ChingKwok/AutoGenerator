package ${project.packageName}.${project.projectCode}.bean.entity;

<#--check import-->
<#list table.columnSet as columnSet>
<#if columnSet == "Date"  >
import java.util.Date;
<#elseif columnSet == "BigDecimal">
import java.math.BigDecimal;
</#if>
</#list>
import lombok.Data;
import ${project.packageName}.${project.projectCode}.common.bean.BaseEntity;

<#if (table.tableComment)?exists>
/**
*   ${(table.tableComment)!""}
*/
</#if>

@Data
public class ${table.entityName} extends BaseEntity {
    private static final long serialVersionUID = 1L;

<#list table.columns as column>
<#if column.isBase == false>
    <#if (column.comment)?exists>
    /**
    *   ${(column.comment)!""}
    */
    </#if>
    private ${column.javaType} ${column.property};

</#if>
</#list>

}