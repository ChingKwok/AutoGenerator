package ${project.packageName}.${project.projectCode}.service;

import ${project.packageName}.${project.projectCode}.common.service.BaseService;
import ${project.packageName}.${project.projectCode}.bean.dto.${table.entityName}DTO;
import ${project.packageName}.${project.projectCode}.bean.dto.${table.entityName}DeleteDTO;
import ${project.packageName}.${project.projectCode}.bean.dto.${table.entityName}SearchDTO;
import ${project.packageName}.${project.projectCode}.bean.entity.${table.entityName};
import ${project.packageName}.${project.projectCode}.bean.vo.${table.entityName}VO;
import ${project.packageName}.${project.projectCode}.common.utils.PagedResult;

public interface ${table.entityName}Service extends BaseService<${table.entityName}> {
    /**
    * 获取${table.tableComment!""}
    * @param ${table.entityName}DTO
    * @return ${table.entityName}VO
    */
    ${table.entityName}VO get${table.entityName}(Long ${table.entityName?uncap_first}Id);

    /**
    * 新增${table.tableComment!""}
    * @param ${table.entityName}DTO ${table.entityName}DTO
    * @return ${table.entityName}VO
    */
    ${table.entityName}VO insert${table.entityName}(${table.entityName}DTO ${table.entityName?uncap_first}DTO);

    /**
    * 更新${table.tableComment!""}
    * @param ${table.entityName}DTO ${table.entityName}DTO
    * @return ${table.entityName}VO
    */
    ${table.entityName}VO update${table.entityName}(${table.entityName}DTO ${table.entityName?uncap_first}DTO);

    /**
    * 删除${table.tableComment!""}
    * @param ${table.entityName}DeleteDTO ${table.entityName}DeleteDTO
    * @return int
    */
    int delete${table.entityName}(${table.entityName}DeleteDTO ${table.entityName?uncap_first}DeleteDTO);

    /**
    * 查询${table.tableComment!""}列表
    * @param map
    * @return PageResult<${table.entityName}VO>
    */
    PagedResult<${table.entityName}VO> search${table.entityName}(${table.entityName}SearchDTO ${table.entityName?uncap_first}SearchDTO);
}