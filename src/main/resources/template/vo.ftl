package ${project.packageName}.${project.projectCode}.bean.vo;

<#--check import-->
<#list table.columnSet as columnSet>
    <#if columnSet == "Date"  >
import java.util.Date;
    <#elseif columnSet == "BigDecimal">
import java.math.BigDecimal;
    </#if>
</#list>
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

<#if (table.tableComment)?exists>
    /**
    *   ${(table.tableComment)!""}
    */
</#if>

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ${table.entityName}VO implements Serializable {
private static final long serialVersionUID = 1L;

<#list table.columns as column>
    <#if (column.comment)?exists>
    /**
    *   ${(column.comment)!""}
    */
    </#if>
    <#if column.javaType == "Date" >
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    <#elseif column.javaType == "String" >
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    </#if>
    @ApiModelProperty(value = "${column.comment}")
    private ${column.javaType} ${column.property};

</#list>

}