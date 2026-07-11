# Experimental Protocol

## Purpose

Define a controlled and auditable comparison of REST API test development under manual, GitHub Copilot-assisted, and ChatGPT-assisted conditions.

## Pre-registration checklist

Before collecting data, record and freeze:

- the target system and lawful means of accessing it;
- tasks and acceptance criteria;
- participant or executor selection, if applicable;
- allocation and ordering of conditions;
- prompts and permitted interactions;
- time limits and stopping rules;
- environment and tool versions;
- metric definitions and statistical analysis plan;
- exclusion, failure, and rerun criteria;
- data management and ethical considerations.

## Conditions

1. **Manual:** no generative AI assistance.
2. **GitHub Copilot:** assistance limited by the protocol in `prompts/github-copilot.md`.
3. **ChatGPT:** assistance limited by the protocol in `prompts/chatgpt.md`.

Shared task material must be equivalent across conditions. Condition ordering and any randomization procedure must be documented before execution.

## Execution procedure

1. Assign a unique run identifier.
2. Capture the commit, environment, condition, and inputs.
3. Follow the condition-specific prompt and interaction rules.
4. Preserve the produced test suite without undocumented correction.
5. Execute the predefined evaluation procedure.
6. Save untouched observations under `datasets/raw/`.
7. Log failures, interventions, exclusions, and deviations.
8. Process and analyze data only after completing the planned collection procedure.

## Status

This is an initial protocol template. Target API endpoints, final tasks, sample size, and analysis decisions have not yet been defined and must not be inferred from this document.
