package com.mbank.assess.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.mbank.assess.bo.UserBO;
import com.mbank.assess.entity.User;
import com.mbank.assess.util.TransformerUtil;

public class UserMapper {
	
	public static List<UserBO> entitiesToBOs(final List<User> entities) {
        return entities.stream().filter(Objects::nonNull).map(UserMapper::entityToBO).collect(Collectors.toList());
    }

    public static UserBO entityToBO(final User entity) {
        UserBO bo = null;
        if (entity != null) {
        	bo = new UserBO();
            TransformerUtil.copyAllUtility(entity, bo);
            if (entity.getCreatedOn() != null) {
            	bo.setCreatedOn(entity.getCreatedOn().toLocalDateTime());
            }
            if (entity.getModifiedOn() != null) {
            	bo.setModifiedOn(entity.getModifiedOn().toLocalDateTime());
            }
        }
        return bo;
    }
    
    public static List<User> boToEntities(final List<UserBO> bos) {
        return bos.stream().filter(Objects::nonNull).map(UserMapper::boToEntity).collect(Collectors.toList());
    }

    public static User boToEntity(final UserBO bo) {
        User entity = null;
        if (bo != null) {
        	entity = new User();
            TransformerUtil.copyAllUtility(bo, entity);
            if (bo.getCreatedOn() != null) {
            	entity.setCreatedOn(Timestamp.valueOf(bo.getCreatedOn()));
            }
            if (bo.getModifiedOn() != null) {
            	entity.setModifiedOn(Timestamp.valueOf(bo.getModifiedOn()));
            }
        }
        return entity;
    }
}
