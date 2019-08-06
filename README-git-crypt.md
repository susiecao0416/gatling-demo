## Preconditions
When use git-crypt, must generate the files first then put the files to be encrpted into the codebase

## Install GPG

First of all, you should install GPG in your computer (if it is not installed yet).
For MAC, there is some tools in [this site](https://gpgtools.org/). An alternative is to run ```brew install gpg```.

Once it's installed, go to the next step.

## Generate a key pair

To generate your own key pair, run the command ```gpg --gen-key```.

Follow the instructions in command line; press *Enter* to accept the default configurations, or, if you have other preferences, now it's time to specify them.

Type your name (e.g. *Gio Sfreddo*) and email (e.g. *gio@gmail.com*). You can skip the "comment" part pressing *Enter*.
Now, you should see the following output with your information:
```
You selected this USER-ID:
"Gio Sfreddo <gio@gmail.com>"
```
Press "O" to continue.

When prompted for a passphrase, type a strong password you'll remember and confirm it.

If everything is OK, now you have a GPG key!

## Export and send your public key

To export your public key as a file, run the command ```gpg --armor --export gio@gmail.com > giordana.asc ```, replacing the email and file name properly.
Now, you'll have a *giordana.asc* file. Send this file to a jigsawer who already have access to encrypted files. You can do it attaching the file to an email. If your mate don't know what to do, show him/her the following step.


## Get some help with an older team member

Now, the older jigsawer who received the email with the public key takes action. She/he should:
* Download the received file (which is the public key)
* Import the received file running ```gpg --import <path-to-file/giordana.asc>```. Note it displays a key in a format like F3A887DA. It's the key ID.
* Sign the key using the new jigsawer's key ID. To do so, run: ```gpg --sign-key <KEY-ID-HERE>```
* Go to code repository and run ```git-crypt add-gpg-user <KEY-ID-HERE>```
* Note a commit has been done. Push it to remote repository.

Thanks, old jigsawer who helped our new friend!

## Install git crypt

In order to see encrypted files, you should install git-crypt. Run the command ```brew install git-crypt``` to do so.

## Get the updated code

Your mate just pushed new code adding you as a trusted contributor. Go and get it! Run ```git pull -r``` in app repository or do it how you're used to.

## Finally get the secret files!

In app code directory, run ```git-crypt unlock```. To check if it is working, access the file *secrets/password*.
Done! =)

--------------------
Some references:
* https://help.github.com/categories/gpg/
* https://access.redhat.com/documentation/en-US/Red_Hat_Enterprise_Linux/3/html/Step_by_Step_Guide/ch-gnupg.html
* https://www.agwa.name/projects/git-crypt/
