package ${project.packageName}.bean.entity;

<#list table.columns as column>
    <#if (column.typeCode >= 91 ) && (column.typeCode <= 93 ) >
import java.util.Date;
    <#elseif column.typeCode == 3 >
import java.math.BigDecimal;
    </#if>
</#list>
import lombok.Data;
import ${project.packageName}.common.bean.BaseEntity;

<#if (table.tableComment)?exists>
/**
*   ${(table.tableComment)!""}
*/
</#if>

@Data
public class ${table.entityName} extends BaseEntity {
    private static final long serialVersionUID = 1L;

<#list table.columns as column>
    <#if (column.comment)?exists>
    /**
    *   ${(column.comment)!""}
    */
    </#if>
    private ${column.javaType} ${column.property};

</#list>

}