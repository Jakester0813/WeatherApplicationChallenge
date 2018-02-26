package com.projects.jakester.weatherapplicationchallenge.dagger;

/**
 * Created by Jake on 2/21/2018.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity{}
