package com.vvsk.jinte;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.testing.Test;

public class JintePlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getTasks().withType(Test.class).configureEach(testTask -> {
            testTask.doLast(task -> {
                project.getLogger().lifecycle("🚀 Running Jinte Integration Tests...");
                // Add JSON-based test execution logic here
            });
        });
    }
}
