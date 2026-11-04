# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository

matte@toni_desktop UCRT64 ~/Desktop/oop-lab06/61-git-remotes-merge-conflict (exercises)
$ git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test
Cloning into 'OOP-git-merge-conflict-test'...
remote: Enumerating objects: 24, done.
remote: Counting objects: 100% (16/16), done.
remote: Compressing objects: 100% (11/11), done.
remote: Total 24 (delta 5), reused 13 (delta 5), pack-reused 8 (from 1)
Receiving objects: 100% (24/24), done.
Resolving deltas: 100% (6/6), done.


2. Ci si assicuri di avere localmente entrambi i branch remoti

$ git branch -a
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master

$ git checkout feature
branch 'feature' set up to track 'origin/feature'.
Switched to a new branch 'feature'


$ git branch
* feature
  master


3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`

$ git status
On branch feature
Your branch is up to date with 'origin/feature'.

nothing to commit, working tree clean

$ git checkout master
Switched to branch 'master'
Your branch is up to date with 'origin/master'.

$ git status
On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean

$ git merge feature
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.

$ git status
On branch master
Your branch is up to date with 'origin/master'.

You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
        both modified:   HelloWorld.java

no changes added to commit (use "git add" and/or "git commit -a")


4. Si noti che viene generato un **merge conflict**!

5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)

     sono andato a modificare il file che dopo il git status ha evidaziato le zone da "mergare" e ora posso riprovare il merge

     $ git add HelloWorld.java

6. Si crei un nuovo repository nel proprio github personale

gia fatto

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote

git remote add personal https://github.com/caccaSBU69/oop-lab06-61

$ git remote -v
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (push)
personal        https://github.com/caccaSBU69/oop-lab06-61 (fetch)
personal        https://github.com/caccaSBU69/oop-lab06-61 (push)

8. Si faccia push del branch `master` sul proprio repository

$ git status
On branch master
Your branch is ahead of 'origin/master' by 4 commits.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean

$ git push personal master
info: please complete authentication in your browser...
Enumerating objects: 27, done.
Counting objects: 100% (27/27), done.
Delta compression using up to 16 threads
Compressing objects: 100% (19/19), done.
Writing objects: 100% (27/27), 3.83 KiB | 3.83 MiB/s, done.
Total 27 (delta 6), reused 24 (delta 6), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (6/6), done.
To https://github.com/caccaSBU69/oop-lab06-61
 * [new branch]      master -> master


9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale

$ git branch --set-upstream-to=personal/master master
branch 'master' set up to track 'personal/master'.
