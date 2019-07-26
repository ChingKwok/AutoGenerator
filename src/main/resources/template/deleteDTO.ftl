package ${project.packageName}.${project.projectCode}.bean.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

<#if (table.tableComment)?exists>
    /**
    *   ${(table.tableComment)!""}
    */
</#if>

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ${table.entityName}DeleteDTO implements Serializable {
private static final long serialVersionUID = 1L;
<#list table.columns as column>
<#--            类型为bit 或 数值-->
    <#if (column.typeCode == -7 ||column.typeCode == -6 ||column.typeCode == -5 || column.typeCode == 4 || column.typeCode == 5 || column.typeCode == 6 || column.typeCode == 3 || column.typeCode == 2 || column.typeCode == 8) && column.isPrimary == true>

    @ApiModelProperty(value = "${column.comment!""}", required = true)
    private ${column.javaType} ${column.property};
    <#--        字符类型-->
    <#elseif (column.typeCode == -1 || column.typeCode == 1 || column.typeCode == 12 )&& column.isPrimary == true>

    @ApiModelProperty(value = "${column.comment!""}", required = true)
    private ${column.javaType} ${column.property};
    </#if>
</#list>
}