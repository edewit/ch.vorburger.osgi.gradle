/**
 * ch.vorburger.osgi.gradle
 *
 * Copyright (C) 2016 - 2017 Michael Vorburger.ch <mike@vorburger.ch>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.vorburger.osgi.builder.internal;

import ch.vorburger.osgi.builder.SourceInstallService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

// TODO remove once @Component on SourceInstallServiceImpl works
public class Activator implements BundleActivator {

    private SourceInstallServiceImpl sourceInstallService;

    @Override
    public void start(BundleContext context) throws Exception {
        sourceInstallService = new SourceInstallServiceImpl(context);
        context.registerService(SourceInstallService.class, sourceInstallService, null);
        context.registerService(ch.vorburger.osgi.gradle.SourceInstallService.class, sourceInstallService, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        sourceInstallService.close();
    }

}
