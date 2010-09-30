package com.cloudera.h2.mr;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSimpleJobManager {

  private static final Logger logger = LoggerFactory
      .getLogger(TestSimpleJobManager.class);

  private SimpleJobManager jobManager;

  @Before
  public void setup() {
    jobManager = new SimpleJobManager();
  }

  @Test
  public void testJobManager() {
    Assert.assertNotNull(jobManager);
    Assert.assertEquals(0, jobManager.getActiveAttempts().size());
  }

  @Test
  public void testSubmitJob() {
    Job job;
    JobAttempt attempt;

    job = new Job();
    attempt = jobManager.submitJob(job);

    Assert.assertNotNull(attempt);
    Assert.assertNotNull(attempt.getId());
    Assert.assertEquals(1, jobManager.getActiveAttempts().size());

    logger.debug("attempt:" + attempt);
  }

}