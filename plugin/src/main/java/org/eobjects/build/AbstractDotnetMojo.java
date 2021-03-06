package org.eobjects.build;

import java.io.File;
import java.util.Map;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

public abstract class AbstractDotnetMojo extends AbstractMojo {

    @Parameter(defaultValue = PluginHelper.PROPERTY_BASEDIR, readonly = true)
    private File basedir;

    @Parameter(property = "environment", required = false)
    private Map<String, String> environment;

    @Parameter(required = false, defaultValue = "false")
    private boolean skip;

    @Parameter(property = "dotnet.pack.output", required = false)
    private File packOutput;

    @Parameter(property = "dotnet.configuration", required = false, defaultValue = "Release")
    private String buildConfiguration;

    public PluginHelper getPluginHelper() {
        return PluginHelper.get(basedir, environment, packOutput, buildConfiguration, skip);
    }
}
