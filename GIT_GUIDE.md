# Git — Important Commands & Basic Flow

A practical guide with real examples from this repo.

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

# What makes a good commit message?
# ✅ "Fix off-by-one error in BubbleSort inner loop"
# ✅ "Add NQueen backtracking — places N queens on NxN board"
# ❌ "fixed stuff"
# ❌ "update"
# ❌ "asdfgh"

# See what you're about to commit before committing
git diff --staged
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
