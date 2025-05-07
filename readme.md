# Kotlin Starter
Directory structure and settings for starting a new Kotlin project.

## Gradle Wrapper
Run `./gradlew wrapper --gradle-version=latest` to update the wrapper to the latest version.

## Plugins & Dependencies
* [ktlint-gradle](https://github.com/JLLeitschuh/ktlint-gradle): `./gradlew ktlintCheck` / `./gradlew ktlintFormat`
* [jib](https://github.com/GoogleContainerTools/jib): `./gradlew jibDockerBuild` / `./gradlew jib`
* [junit5](https://junit.org/junit5/): `./gradlew test`
* [dotenv-kotlin](https://github.com/cdimascio/dotenv-kotlin): automatically load `.env`
* [kotlinx-coroutines](https://github.com/Kotlin/kotlinx.coroutines): library support for kotlin coroutines
* [kotlin-logging](https://github.com/oshai/kotlin-logging): logging setup with [slf4j](https://github.com/qos-ch/slf4j), [logback](https://github.com/qos-ch/logback) and a custom [logback.xml](modules/app/src/main/resources/logback.xml)

## Aliases
* `verify` = `ktlintCheck,test`

## Settings for a new GitHub repository
* license "The Unlicense"
* settings / general
  * automatically delete head branches
  * preserve this repository (uncheck)
  * allow auto-merge (for `auto-approve-merge` GitHub Actions workflow)
* settings / pull request
  * allow squash merging
    * default commit message: pull request title
* settings / branches
  * branche protection rule for `main`
    * require a pull request before merging
    * pull request requires approval
    * require status checks to pass before merging (add `kotlin-build.yml` GitHub Actions workflow)
    * require branches to be up-to-date
* settings / actions / general
  * allow gitHub actions to create and approve pull requests (for `auto-approve-merge` GitHub Actions workflow)

## GitHub Actions
* workflow `kotlin-build.yml` automatically checks for formatting and passing of all tests
* workflow `auto-approve-merge.yml` automatically approves and merges PRs labeled `auto-approve-merge`
