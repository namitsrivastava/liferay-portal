/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.document.library.repository.cmis.internal;

import aQute.bnd.annotation.metatype.Configurable;

import com.liferay.document.library.repository.cmis.configuration.CMISRepositoryConfiguration;
import com.liferay.document.library.repository.cmis.internal.constants.CMISRepositoryConstants;
import com.liferay.portal.kernel.lock.LockManager;
import com.liferay.portal.kernel.repository.RepositoryFactory;
import com.liferay.portal.service.CompanyLocalService;
import com.liferay.portal.service.RepositoryEntryLocalService;
import com.liferay.portal.service.RepositoryLocalService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portlet.asset.service.AssetEntryLocalService;
import com.liferay.portlet.documentlibrary.service.DLAppHelperLocalService;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalService;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(
	immediate = true,
	property = {
		"repository.targetClassName=" + CMISRepositoryConstants.CMIS_WEB_SERVICES_REPOSITORY_CLASSNAME
	},
	service = RepositoryFactory.class
)
public class CMISWebServicesRepositoryFactory
	extends BaseCMISRepositoryFactory<CMISWebServicesRepository> {

	@Activate
	protected void activate(Map<String, Object> properties) {
		CMISRepositoryConfiguration cmisRepositoryConfiguration =
			Configurable.createConfigurable(
				CMISRepositoryConfiguration.class, properties);

		super.setCMISRepositoryConfiguration(cmisRepositoryConfiguration);
	}

	@Override
	protected CMISWebServicesRepository createBaseRepository() {
		return new CMISWebServicesRepository();
	}

	@Override
	@Reference(unbind = "-")
	protected void setAssetEntryLocalService(
		AssetEntryLocalService assetEntryLocalService) {

		super.setAssetEntryLocalService(assetEntryLocalService);
	}

	@Override
	@Reference(unbind = "-")
	protected void setCompanyLocalService(
		CompanyLocalService companyLocalService) {

		super.setCompanyLocalService(companyLocalService);
	}

	@Override
	@Reference(unbind = "-")
	protected void setDLAppHelperLocalService(
		DLAppHelperLocalService dlAppHelperLocalService) {

		super.setDLAppHelperLocalService(dlAppHelperLocalService);
	}

	@Override
	@Reference(unbind = "-")
	protected void setDLFolderLocalService(
		DLFolderLocalService dlFolderLocalService) {

		super.setDLFolderLocalService(dlFolderLocalService);
	}

	@Reference(unbind = "-")
	protected void setLockManager(LockManager lockManager) {
		super.setLockManager(lockManager);
	}

	@Override
	@Reference(unbind = "-")
	protected void setRepositoryEntryLocalService(
		RepositoryEntryLocalService repositoryEntryLocalService) {

		super.setRepositoryEntryLocalService(repositoryEntryLocalService);
	}

	@Override
	@Reference(unbind = "-")
	protected void setRepositoryLocalService(
		RepositoryLocalService repositoryLocalService) {

		super.setRepositoryLocalService(repositoryLocalService);
	}

	@Override
	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		super.setUserLocalService(userLocalService);
	}

}