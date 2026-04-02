# Git — Important Commands & Basic Flow

A practical guide with real examples from this repo (`algorithms` and `node-learnings`).

---

## What is Git?

Git tracks changes to your files over time. Think of it as a **save history** — you can go back to any point, work on different features in parallel, and collaborate with others.

```
Your files  →  Staging area  →  Local repo  →  Remote repo (GitHub)
(working)       (git add)        (git commit)    (git push)
```

---

## Initial Setup (one time only)

```bash
# Tell Git who you are — shows up in every commit
git config --global user.name "Shubham Garg"
git config --global user.email "schmuck21@gmail.com"

# Check what's set
git config --global --list
```

---

## Starting a Repository

### Option A — New project from scratch
```bash
mkdir algorithms
cd algorithms
git init                    # creates a hidden .git folder — Git starts tracking here
```

### Option B — Download an existing repo from GitHub
```bash
git clone https://github.com/shubhaga1/algorithms.git
cd algorithms
```

---

## Daily Workflow

This is what you do every time you write code:

```
1. Write/edit code
2. git status       → see what changed
3. git add          → stage the changes
4. git commit       → save a snapshot
5. git push         → upload to GitHub
```

### Step-by-step with this repo as example:

```bash
# 1. You edited BST.java and created a new file Trie.java

# 2. Check what changed
git status
# Output:
#   modified:   tree/BST.java
#   untracked:  tree/Trie.java

# 3. Stage the files you want to commit
git add tree/BST.java
git add tree/Trie.java

# Or stage everything at once
git add .

# 4. Commit with a meaningful message
git commit -m "Add Trie insert and search, fix BST delete for leaf nodes"

# 5. Push to GitHub
git push
```

---

## git status — what's happening right now

```bash
git status
```

Output explained:
```
On branch main                        ← which branch you're on

Changes to be committed:              ← staged (will go in next commit)
    modified:   tree/BST.java

Changes not staged for commit:        ← changed but NOT staged yet
    modified:   recursion/Factorial.java

Untracked files:                      ← new files Git doesn't know about yet
    array/LinearSearch.java
```

---

## git add — staging changes

```bash
# Add one file
git add tree/BST.java

# Add all files in a folder
git add tree/

# Add everything changed
git add .

# Add specific file types
git add *.java
```

> **Staging = deciding what goes into the next commit.**
> You don't have to commit everything at once.

---

## git commit — saving a snapshot

```bash
# Short message
git commit -m "Add BinarySearch iterative and recursive versions"

# -am shortcut: stage ALL modified files AND commit in one command
git commit -am "Fix off-by-one error in BubbleSort inner loop"
# ⚠️  -a only stages files already tracked (modified)
# ⚠️  New files (untracked) still need git add first

# So the difference is:
git add .                              # stages everything including new files
git commit -m "msg"                    # commit what's staged

git commit -am "msg"                   # shortcut — skips git add for modified files only

# See what you're about to commit before committing
git diff --staged
```

---

## Commit Message Best Practices

### The format

```
<type>: <short summary>          ← subject line (max 72 chars)

<longer explanation if needed>   ← body (optional, leave blank line above)
```

---

### Types — use one prefix consistently

| Type | When to use | Example |
| --- | --- | --- |
| `Add` | New file, feature, class | `Add NQueen backtracking solution` |
| `Fix` | Bug fix | `Fix off-by-one in BubbleSort inner loop` |
| `Update` | Change to existing feature | `Update BST delete to handle two-child case` |
| `Remove` | Delete code or files | `Remove duplicate LinearSearch from spring-leetcode` |
| `Refactor` | Restructure without behavior change | `Refactor MazePaths into 3 focused classes` |
| `Move` | Move files between folders | `Move ZeroFilledSubarrays to array package` |
| `Rename` | Rename files or classes | `Rename Fibonacci to 02_Fibonacci for ordering` |
| `Fix build` | Compilation or tooling fix | `Fix build: remove nested .git from security-poc` |

---

### Rules

#### 1. Subject line answers: what + why (not how)

```bash
✅ "Fix BST delete — leaf node case returned wrong parent"
✅ "Add amortised O(1) demo to show ArrayList resize cost"
❌ "updated BST.java"
❌ "changes"
❌ "fix"
```

#### 2. Use present tense, imperative mood

```bash
✅ "Add Trie search"        (like a command)
❌ "Added Trie search"
❌ "Adding Trie search"
```

#### 3. Max 72 characters in subject line

```bash
✅ "Add NQueen backtracking — places N queens on NxN board"   (55 chars)
❌ "Add NQueen backtracking solution that places N queens on an NxN board using recursion"
```

#### 4. One commit = one logical change

```bash
✅ Commit 1: "Add MaxHeap insert"
   Commit 2: "Add MaxHeap extractMax"
❌ One commit: "Add MaxHeap insert and extractMax and fix BST and rename files"
```

#### 5. Don't describe what is obvious from the diff

```bash
✅ "Fix stack overflow in Fibonacci — missing base case for n=1"
❌ "Add if statement to Fibonacci.java"   ← git diff already shows this
```

---

### Real examples from this repo

```bash
# ✅ Good — says what AND why
git commit -m "Fix and perfect all recursion classes — compilable and runnable"
git commit -m "Add visual grid printer to Maze1Recursive to show path as * on grid"
git commit -m "Rewrite README with full project learnings, VS Code setup, git config"

# ✅ Good — short and clear
git commit -m "Add ZeroFilledSubarrays (LeetCode 2348) to array package"
git commit -m "Move ZeroFilledSubarrays from spring-leetcode to algorithms/array"

# ❌ Bad — already in this repo's history
git commit -m "added scanner method"     # lowercase, no context
git commit -m "Array2D class and run.sh" # what changed, not why
```

---

### When to add a body (multi-line)

Use a body when the subject line isn't enough to explain the decision:

```bash
git commit -m "Refactor MazePaths into 3 focused classes

Split one large class into:
- Maze1Recursive: basic path counting
- Maze2CollectPaths: collect all paths as ArrayList
- Maze3Visual: print grid with * markers

Each class builds on the previous — easier to learn step by step."
```

---

## git push / pull — syncing with GitHub

```bash
# Upload your commits to GitHub
git push

# First time pushing a new branch
git push -u origin main

# Download latest changes from GitHub (someone else pushed)
git pull

# Pull = fetch + merge
# fetch  → download changes but don't apply
# merge  → apply them to your branch
```

---

## git log — see commit history

```bash
# Full history
git log

# Clean one-line view (most useful)
git log --oneline
# Output:
# 6e10f92 Array2D class and arraylistmethods
# d235bbb Add ArrayListAmortised: simulate ArrayList resize
# 92b0929 Add ArrayListUtils: max, swap, reverse
# 07c5d7e Add LinearSearch: int array, String array, char search

# Show last 5 commits
git log --oneline -5

# Show who changed what line in a file (blame)
git log --oneline tree/BST.java

# Show changes made in a specific commit
git show 6e10f92
```

---

## git diff — see what changed

```bash
# What changed but not staged yet
git diff

# What's staged (about to be committed)
git diff --staged

# Compare two commits
git diff abc1234 def5678

# Compare specific file between commits
git diff HEAD~1 HEAD tree/BST.java
#                    ↑ previous commit vs current
```

---

## Undoing Mistakes

### Unstage a file (before commit)
```bash
# You ran git add by mistake
git restore --staged tree/BST.java
# File is still changed, just removed from staging
```

### Discard changes in a file (dangerous — cannot undo)
```bash
# Throw away all edits to a file, go back to last commit
git restore tree/BST.java
```

### Undo last commit but keep the changes
```bash
# "I committed too early, I want to edit more"
git reset HEAD~1
# Commit is undone, files are still changed and staged
```

### See what a file looked like in a previous commit
```bash
git show abc1234:tree/BST.java
```

---

## Branches — working on features in parallel

```bash
# See all branches
git branch

# Create a new branch
git branch feature/add-heap

# Switch to it
git checkout feature/add-heap

# Shortcut: create and switch in one command
git checkout -b feature/add-heap

# Do your work, commit as usual...
git add heap/MaxHeap.java
git commit -m "Add MaxHeap with insert and extractMax"

# Switch back to main
git checkout main

# Merge your feature into main
git merge feature/add-heap

# Delete the branch after merging
git branch -d feature/add-heap
```

**When to use branches:**
- New feature you're not sure about
- Experimental refactoring
- Working with others (each person on their own branch)

---

## .gitignore — files Git should never track

```bash
# Create .gitignore in project root
# This repo's .gitignore:

target/          # compiled .class files
*.class          # any Java bytecode
.DS_Store        # macOS junk
*.iml            # IntelliJ files
.idea/           # IntelliJ project folder
```

Files listed here are completely ignored — `git status` won't show them.

---

## Rewriting History (advanced)

### Change commit messages across all history
```bash
# Used in this repo to remove Co-Authored-By lines
git filter-branch --msg-filter 'grep -v "^Co-Authored-By: Claude"' -- --all
git push --force   # must force push since commit hashes changed
```

### Change author email across all history
```bash
# Used in this repo to update email to schmuck21@gmail.com
git filter-branch --env-filter '
    export GIT_AUTHOR_EMAIL="schmuck21@gmail.com"
    export GIT_COMMITTER_EMAIL="schmuck21@gmail.com"
' -- --all
git push --force
```

> Force push rewrites GitHub history. Only do this on your own repos.

---

## Remote — connecting to GitHub

```bash
# See what remote is configured
git remote -v

# Add a remote (if you started locally with git init)
git remote add origin https://github.com/shubhaga1/algorithms.git

# Change remote URL
git remote set-url origin https://github.com/shubhaga1/algorithms.git

# Push and set upstream (first push)
git push -u origin main
# After this, just git push works
```

---

## Common Errors & Fixes

### "rejected — non-fast-forward"
```bash
# Someone else pushed, your history is behind
git pull --rebase    # download their changes, put yours on top
git push
```

### "nothing to commit, working tree clean"
```bash
# Nothing has changed since last commit — this is fine
git status   # confirms you're up to date
```

### "Untracked files" not going away
```bash
# File is new — Git doesn't track it until you add it
git add filename.java
```

### Accidentally committed to wrong branch
```bash
git log --oneline -1        # note the commit hash, e.g. abc1234
git reset HEAD~1            # undo commit, keep changes
git checkout correct-branch
git add .
git commit -m "same message"
```

---

## Real Commands Used in This Project

Every command below was actually run while building the `algorithms` and `node-learnings` repos.

### Starting the repos

```bash
# algorithms — started locally, then pushed to GitHub
git init
git add .
git commit -m "Create InsertTree.java"
git remote add origin https://github.com/shubhaga1/algorithms.git
git push -u origin main

# node-learnings — created and pushed in one shot using GitHub CLI
gh repo create node-learnings --public --source . --remote origin --push
```

---

### Everyday commits in algorithms

```bash
# Adding a new class
git add tree/Trie.java
git commit -m "Add Trie insert and search"
git push

# Fixing multiple files at once
git add recursion/
git commit -m "Fix and perfect all recursion classes — compilable and runnable"
git push

# Moving files between folders (delete old, add new)
git add algorithms/array/ZeroFilledSubarrays.java
git commit -m "Move ZeroFilledSubarrays from spring-leetcode to algorithms/array"
git push
```

---

### Fixing the nested git problem (security-poc inside algorithms)

```bash
# Problem: security-poc had its own .git — Git treated it as a submodule
# Fix: remove the nested .git, then re-add as regular files

git rm --cached security-poc           # remove submodule reference
rm -rf security-poc/.git               # delete nested git
git add security-poc/                  # re-add as normal files
git commit -m "Fix security-poc: remove nested git"
git push
```

---

### Rewriting history — removing Co-Authored-By from all commits

```bash
# Ran on both algorithms (146 commits) and node-learnings (2 commits)
FILTER_BRANCH_SQUELCH_WARNING=1 git filter-branch -f \
  --msg-filter 'grep -v "^Co-Authored-By: Claude"' \
  -- --all

git push --force    # hashes changed so must force push
```

---

### Rewriting history — changing email across all commits

```bash
# Changed from jobs.shubhamgarg@email.com → schmuck21@gmail.com
# So GitHub contribution graph shows correctly
git filter-branch --env-filter '
    export GIT_AUTHOR_EMAIL="schmuck21@gmail.com"
    export GIT_COMMITTER_EMAIL="schmuck21@gmail.com"
' -- --all

git push --force
```

---

### When push was rejected (diverged history)

```bash
# Error: "Updates were rejected because the remote contains work you do not have"
# Happened after force-rewriting history

# Fix 1: stash changes, force push, restore
git stash
git push --force
git stash pop

# Fix 2: if normal diverge (not history rewrite)
git pull --rebase
git push
```

---

### Checking commits in both repos

```bash
# algorithms — 146 commits
cd algorithms
git log --oneline

# node-learnings — 2 commits
cd node-learnings
git log --oneline

# See a specific commit's full changes
git show 1824392

# See what changed in a file over time
git log --oneline tree/BST.java
```

---

### Deleting GitHub repos via CLI

```bash
# Deleted security-poc and algorithms-and-security-poc repos
gh repo delete shubhaga1/security-poc --yes
gh repo delete shubhaga1/algorithms-and-security-poc --yes

# Verify what repos remain
gh repo list shubhaga1
```

---

## Quick Reference Card

| Command | What it does |
|---|---|
| `git init` | Start tracking a folder |
| `git clone <url>` | Download a repo from GitHub |
| `git status` | See what's changed |
| `git add <file>` | Stage a file for commit |
| `git add .` | Stage everything |
| `git commit -m "msg"` | Save a snapshot |
| `git push` | Upload to GitHub |
| `git pull` | Download from GitHub |
| `git log --oneline` | See commit history |
| `git diff` | See unstaged changes |
| `git diff --staged` | See staged changes |
| `git restore <file>` | Discard changes in a file |
| `git restore --staged <file>` | Unstage a file |
| `git branch <name>` | Create a branch |
| `git checkout <branch>` | Switch branch |
| `git merge <branch>` | Merge branch into current |
| `git push --force` | Overwrite remote history |
