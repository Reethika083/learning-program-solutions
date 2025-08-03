import React from 'react';
import { render, screen } from '@testing-library/react';
import CohortDetails from './CohortDetails.js';
import { CohortData } from './Cohort';

test('renders a cohort item', () => {
  render(<CohortDetails cohorts={CohortData} />);
  const cohortElement = screen.getByText(/cohort/i); // Update this if your cohort names are different
  expect(cohortElement).toBeInTheDocument();
});
