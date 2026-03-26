@echo off
SET "DIR=tmp_svg"
IF NOT EXIST "%DIR%" mkdir "%DIR%"

echo Downloading icons to %DIR%...

:: Уведомления
curl -L -o "%DIR%\ic_check.svg" "https://www.figma.com/api/mcp/asset/9e7fa575-6515-4435-a826-162927cfff50"
curl -L -o "%DIR%\ic_not_available.svg" "https://www.figma.com/api/mcp/asset/5710d6ac-7304-4f8e-a662-38764dda95ba"
curl -L -o "%DIR%\ic_question.svg" "https://www.figma.com/api/mcp/asset/e46002a3-1c5a-49f5-9813-142d68a890c1"
curl -L -o "%DIR%\ic_warning.svg" "https://www.figma.com/api/mcp/asset/ead46fb3-07b8-48ff-9805-a2aae6f663fe"

:: Связанные аккаунты
curl -L -o "%DIR%\ic_edit.svg" "https://www.figma.com/api/mcp/asset/516f3e0b-0b05-4af6-9574-5f587284b256"
curl -L -o "%DIR%\ic_refill.svg" "https://www.figma.com/api/mcp/asset/56ef7e82-a9ad-4065-95d4-fb1e585fa796"
curl -L -o "%DIR%\ic_unlink.svg" "https://www.figma.com/api/mcp/asset/811ec7d7-1b73-4260-a752-e1af316a741e"
curl -L -o "%DIR%\ic_goto.svg" "https://www.figma.com/api/mcp/asset/cc715ad5-f74a-4ac3-b1b8-1a135c35b7cf"
curl -L -o "%DIR%\ic_linked.svg" "https://www.figma.com/api/mcp/asset/ed6fdbb0-84f0-4ef1-b192-aa75afb9ff3d"
curl -L -o "%DIR%\ic_plus.svg" "https://www.figma.com/api/mcp/asset/1d6f3d9a-7a8d-4e39-952b-f36115069ae4"
curl -L -o "%DIR%\ic_list.svg" "https://www.figma.com/api/mcp/asset/99b56b27-68ab-48bc-bdcc-6f386300f5d5"
curl -L -o "%DIR%\ic_grid.svg" "https://www.figma.com/api/mcp/asset/b71fbe59-096f-48e0-9d46-21c489b25326"

:: Подключи друга
curl -L -o "%DIR%\ic_ellipse.svg" "https://www.figma.com/api/mcp/asset/31b10f8d-b850-4c74-ae00-178baa7f19b3"
curl -L -o "%DIR%\ic_arrow_down.svg" "https://www.figma.com/api/mcp/asset/18e1f3fd-b732-46af-8bba-4187ecc6f687"

:: Платежи и Способы оплаты
curl -L -o "%DIR%\ic_calendar.svg" "https://www.figma.com/api/mcp/asset/eca56b5e-bd4e-48d7-84c1-dff4f234b28f"
curl -L -o "%DIR%\ic_wallet.svg" "https://www.figma.com/api/mcp/asset/d2102efe-adbd-4297-bb6f-de2ff6de221a"
curl -L -o "%DIR%\ic_sber_logo.svg" "https://www.figma.com/api/mcp/asset/74eb2ed5-c8b3-4c85-91ce-806c45439343"
curl -L -o "%DIR%\ic_arrow_right_blue.svg" "https://www.figma.com/api/mcp/asset/33a1936a-8799-4609-87fa-9701fb09c0a0"

:: Техподдержка
curl -L -o "%DIR%\ic_support_phone.svg" "https://www.figma.com/api/mcp/asset/6b0f9bf6-fd56-4be4-aaf1-2dfce2e0bc85"
curl -L -o "%DIR%\ic_support_warning.svg" "https://www.figma.com/api/mcp/asset/6d89e7e9-6b55-4bc1-9fcd-ce80e7b790be"
curl -L -o "%DIR%\ic_support_send.svg" "https://www.figma.com/api/mcp/asset/bfd8c0db-125b-4e7b-a8b4-6ce2a6c80084"
curl -L -o "%DIR%\ic_support_operator.svg" "https://www.figma.com/api/mcp/asset/51919148-fbd8-49e6-af25-133aed845e96"
curl -L -o "%DIR%\ic_op_mks.svg" "https://www.figma.com/api/mcp/asset/7c7500bb-0b6f-400f-9634-cc72330d69b8"
curl -L -o "%DIR%\ic_op_plus7.svg" "https://www.figma.com/api/mcp/asset/f1c5c331-fc49-4310-9f39-a0dd9317b419"
curl -L -o "%DIR%\ic_op_cityphone.svg" "https://www.figma.com/api/mcp/asset/d1b30fc9-ecb0-4c97-83a3-e0fe544f4941"
curl -L -o "%DIR%\ic_op_nadofon.svg" "https://www.figma.com/api/mcp/asset/3c83ed0e-c95f-4a1d-9888-08fb07acffb9"
curl -L -o "%DIR%\ic_status_read.svg" "https://www.figma.com/api/mcp/asset/8b88defd-c0df-4be3-a667-55cf3025c378"
curl -L -o "%DIR%\ic_vk.svg" "https://www.figma.com/api/mcp/asset/102e1ddf-32d7-42ad-a9f1-3221c55d841d"
curl -L -o "%DIR%\ic_telegram.svg" "https://www.figma.com/api/mcp/asset/79b8ab17-729e-4042-aa2b-30492d9d6c48"

:: Сменить тариф
curl -L -o "%DIR%\ic_back_arrow.svg" "https://www.figma.com/api/mcp/asset/de9ce478-b1d8-40f4-ac89-35f4f306b693"
curl -L -o "%DIR%\ic_details_blue.svg" "https://www.figma.com/api/mcp/asset/ff74af80-f053-4ce4-990d-58480e2ad366"
curl -L -o "%DIR%\ic_bullet_dot.svg" "https://www.figma.com/api/mcp/asset/cd9112fc-eaf5-4fa8-a564-de1d8f1725b4"
curl -L -o "%DIR%\ic_tariff_tv.svg" "https://www.figma.com/api/mcp/asset/b8d67fe8-a15f-4a2a-b158-07ffa3510e35"
curl -L -o "%DIR%\ic_tariff_hyper.svg" "https://www.figma.com/api/mcp/asset/88d75f5d-f008-4f6e-bb10-ee5dbddcef77"

:: Услуга Гипер
curl -L -o "%DIR%\ic_minus_circle.svg" "https://www.figma.com/api/mcp/asset/9c19bc47-545c-4e28-9ea6-4f359096c240"
curl -L -o "%DIR%\ic_plus_circle.svg" "https://www.figma.com/api/mcp/asset/fcaa1cae-6278-4e06-9a52-b002fc6f358f"
curl -L -o "%DIR%\ic_dialog_close.svg" "https://www.figma.com/api/mcp/asset/46784929-ce6d-4ad8-9a25-eb7756423cc9"

:: Тулбар
curl -L -o "%DIR%\ic_toolbar_logo.svg" "https://www.figma.com/api/mcp/asset/112920b2-aff7-4e06-97d7-56464ad9790f"
curl -L -o "%DIR%\ic_toolbar_warning_symbol.svg" "https://www.figma.com/api/mcp/asset/d8d9cb0d-1c79-4af4-9585-f702f0bb4aaa"
curl -L -o "%DIR%\ic_toolbar_messages.svg" "https://www.figma.com/api/mcp/asset/bb2197b2-0bbe-49b8-8054-9da14f3c6c31"

echo Done. Check the %DIR% folder.
curl -L -o "%DIR%\ic_menu_vector.svg" "https://www.figma.com/api/mcp/asset/d1d02fbe-86bd-4bd5-9974-8fc4945cf65c"
curl -L -o "%DIR%\ic_menu_vector1.svg" "https://www.figma.com/api/mcp/asset/58b18880-d4f1-4d5e-be29-6ac591261c4d"
curl -L -o "%DIR%\ic_menu_vector2.svg" "https://www.figma.com/api/mcp/asset/3e7296d7-7790-4318-b1fb-46766f4119d1"
curl -L -o "%DIR%\ic_menu_vector3.svg" "https://www.figma.com/api/mcp/asset/1c57b8e1-ec82-4a62-a15a-4dbd19c728b1"
curl -L -o "%DIR%\ic_menu_vector4.svg" "https://www.figma.com/api/mcp/asset/6e40ad68-34ea-4fe7-920d-be9e93fa42ba"
curl -L -o "%DIR%\ic_menu_vector5.svg" "https://www.figma.com/api/mcp/asset/589ce7bf-b6cc-4d5e-8d4d-9eb590e959b0"
curl -L -o "%DIR%\ic_menu_vector6.svg" "https://www.figma.com/api/mcp/asset/ceb77456-c9fa-4bbc-a73c-c8d7ed7dd79d"
curl -L -o "%DIR%\ic_menu_vector7.svg" "https://www.figma.com/api/mcp/asset/50310f8a-93fc-4010-8987-f0d940eb77ef"
curl -L -o "%DIR%\ic_menu_vector8.svg" "https://www.figma.com/api/mcp/asset/759c3fc2-a862-4164-826b-d5802a74b9f3"
curl -L -o "%DIR%\ic_menu_vector9.svg" "https://www.figma.com/api/mcp/asset/0d61c9d5-9381-4565-9314-3c2d58731bb7"
curl -L -o "%DIR%\ic_menu_vector10.svg" "https://www.figma.com/api/mcp/asset/bc6e54d3-c256-4ef7-80c9-309012e8b7fb"
curl -L -o "%DIR%\ic_menu_ellipse2.svg" "https://www.figma.com/api/mcp/asset/9f65a95c-cd8e-4acc-90fb-3ebd627b76b8"
curl -L -o "%DIR%\ic_menu_vector11.svg" "https://www.figma.com/api/mcp/asset/322a8c72-2698-4473-bf02-d85d45afac2f"
curl -L -o "%DIR%\ic_menu_vector12.svg" "https://www.figma.com/api/mcp/asset/27819690-3021-486e-b30e-d0e07d595540"
curl -L -o "%DIR%\ic_menu_vector13.svg" "https://www.figma.com/api/mcp/asset/1547bbea-7981-48a1-bb72-046e0d234502"
curl -L -o "%DIR%\ic_menu_vector_stroke.svg" "https://www.figma.com/api/mcp/asset/fa82786a-d7c1-430c-a043-ffa82afbd47e"
curl -L -o "%DIR%\ic_menu_vector_stroke1.svg" "https://www.figma.com/api/mcp/asset/8c25407a-0114-4661-9bce-86eb76a4688a"

:: Тулбар
curl -L -o "%DIR%\ic_toolbar_messages.svg" "https://www.figma.com/api/mcp/asset/bb2197b2-0bbe-49b8-8054-9da14f3c6c31"
curl -L -o "%DIR%\ic_toolbar_warning_circle.svg" "https://www.figma.com/api/mcp/asset/2f7b9ef5-807c-4b64-8e26-6808d20c670f"
curl -L -o "%DIR%\ic_toolbar_warning_symbol.svg" "https://www.figma.com/api/mcp/asset/d8d9cb0d-1c79-4af4-9585-f702f0bb4aaa"
curl -L -o "%DIR%\ic_toolbar_menu_burger.svg" "https://www.figma.com/api/mcp/asset/0fcf44bf-207b-47a5-a053-57ace5cef0d5"

echo Done. Check the %DIR% folder.
pause