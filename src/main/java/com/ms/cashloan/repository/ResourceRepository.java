package com.ms.cashloan.repository;
import com.ms.cashloan.bean.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wuketao on 2017/10/19.
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {
}
