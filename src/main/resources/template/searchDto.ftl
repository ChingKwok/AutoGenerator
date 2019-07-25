package ${project.packageName}.bean.dto;

<#list table.columns as column>
    <#if (column.typeCode >= 91 ) && (column.typeCode <= 93 ) >
        import java.util.Date;
    <#elseif column.typeCode == 3 >
        import java.math.BigDecimal;
    </#if>
</#list>
import com.common.entity.SearchBean;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

<#if (table.tableComment)?exists>
    /**
    *   ${(table.tableComment)!""}
    */
</#if>

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ${table.entityName}SearchDTO extends SearchBean {
    private static final long serialVersionUID = 1L;
<#list table.columns as column>
<#--            类型为bit 或 数值-->
<#if column.typeCode == -7 ||column.typeCode == -6 ||column.typeCode == -5 || column.typeCode == 4 || column.typeCode == 5 || column.typeCode == 6 || column.typeCode == 3 || column.typeCode == 2 || column.typeCode == 8>

    @ApiModelProperty(value = "${column.comment!""}", required = true)
    private ${column.javaType} eq${column.property?cap_first};
<#--        字符类型-->
<#elseif column.typeCode == -1 || column.typeCode == 1 || column.typeCode == 12>

    @ApiModelProperty(value = "${column.comment!""}", required = true)
    private ${column.javaType} like${column.property?cap_first};
<#--        日期类型-->
<#elseif  (column.typeCode >= 91) && (column.typeCode <= 93)>

    @ApiModelProperty(value = "${column.comment!""}", required = true)
    private ${column.javaType} gt${column.property?cap_first};

    @ApiModelProperty(value = "${column.comment!""}", required = true)
    private ${column.javaType} lt${column.property?cap_first};
</#if>
</#list>
}