package cn.tzs.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.tzs.dao.ContractDao;
import cn.tzs.domain.Contract;
import cn.tzs.service.ContractService;
import cn.tzs.utils.UtilFuns;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractDao contractDao;
	
	public Contract findOne(String id) {//根据id查询
		return contractDao.findOne(id);
	}

	public void saveOrUpdate(Contract contract) {//保存或更新
		if(UtilFuns.isEmpty(contract.getId())){  //判断是否新增，根据对象id

		}else{
			
		}
		contractDao.save(contract);
	}

	public void saveOrUpdateAll(Collection<Contract> entitys) {//批量保存或更新
		for (Contract contract : entitys) {
			contractDao.save(contract);
		}
	}

	public void deleteById(String id) {//根据id删除
		contractDao.delete(id);
	}

	public void delete(String[] ids) {//批量删除
		for (String id : ids) {
			contractDao.delete(id);
		}
	}

	//根据条件查询所有
	public List<Contract> find(Specification<Contract> spec) {
		return contractDao.findAll(spec);
	}

	//分页查询
	public Page<Contract> findPage(Specification<Contract> spec, Pageable pageable) {
		return contractDao.findAll(spec, pageable);
	}

}
