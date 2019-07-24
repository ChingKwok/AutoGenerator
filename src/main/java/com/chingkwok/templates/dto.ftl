package ${project.packageName}.${project.projectCode}.bean.dto;
import lombok.Data;
import ${project.packageName}.${project.projectCode}.common.bean.SearchBean;

<#if (table.tableComment)?exists>
    /**
    *   ${(table.tableComment)!""}
    */
</#if>

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ${table.entityName}DTO extends SearchBean {
    private static final long serialVersionUID = 1L;

<#list table.columns as column>
    @ApiModelProperty(value = "${column.comment!""}", required = true)
<#--            类型为boolean-->
    <#if column.typeCode ==
    <#if column.typeCode == -5 || column.typeCode == 4 || column.typeCode == 5 || column.typeCode == 6 || column.typeCode == 3 || column.typeCode == 2 || column.typeCode == 8>
        <if test="eq${column.property?cap_first} != null">
            and ${table.alias}.${column.name} = ${"#"}{eq${column.property?cap_first},jdbcType=${column.typeName}}}
        </if>
    <#--            类型为字符串类型-->
    <#elseif column.typeCode == -1 || column.typeCode == 1 || column.typeCode == 12>
        <if test="like${column.property?cap_first} != null">
            and ${table.alias}.${column.name} like CONCAT('%',${"#"}{like${column.property?cap_first},jdbcType=${column.typeName}},'%')
        </if>
<#--        日期类型-->
    <#elseif  (column.typeCode >= 91) && (column.typeCode <= 93)>
        <if test="gt${column.property?cap_first} != null">
            and ${table.alias}.${column.name} <![CDATA[ > ]]> ${"#"}{gt${column.property?cap_first},jdbcType=${column.typeName}}
        </if>
        <if test="lt${column.property?cap_first} != null">
            and ${table.alias}.${column.name} <![CDATA[ < ]]>  ${"#"}{lt${column.property?cap_first},jdbcType=${column.typeName}}
        </if>
    </#if>
</#list>