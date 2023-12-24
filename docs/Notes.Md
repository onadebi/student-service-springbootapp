## Useful Maven Terminal commands run in order:


| Phase    | Action                                                        |
|----------|--------------------------------------------------------------|
| clean    | Delete target directory.                                     |
| validate | Validate if the project is correct.                          |
| compile  | Compile source code, classes stored in target/classes.       |
| test     | Run tests.                                                   |
| package  | Take the compiled code and package it in its distributable format, e.g. JAR, WAR. |
| verify   | Run any checks to verify the MVN package is valid and meets quality criteria. |
| install  | Install the package into the local repository.                |
| deploy   | Copies the final MVN package to the remote repository.        |
~~~~